package Dasgal2;

import java.util.*;

public class Solution {

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int appleCount = 0;
        int orangeCount = 0;

        // Calculate positions of apples and count those in range [s, t]
        for (int d : apples) {
            int position = a + d;
            if (position >= s && position <= t) {
                appleCount++;
            }
        }

        // Calculate positions of oranges and count those in range [s, t]
        for (int d : oranges) {
            int position = b + d;
            if (position >= s && position <= t) {
                orangeCount++;
            }
        }

        System.out.println(appleCount);
        System.out.println(orangeCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read house boundaries
        int s = scanner.nextInt();
        int t = scanner.nextInt();

        // Read tree positions
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // Read number of fruits
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Read apple distances
        List<Integer> apples = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            apples.add(scanner.nextInt());
        }

        // Read orange distances
        List<Integer> oranges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            oranges.add(scanner.nextInt());
        }

        // Calculate and print results
        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}