package Dasgal4;

import java.util.*;

public class Solution {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Find LCM of all elements in list 'a'
        int lcm = a.get(0);
        for (int num : a) {
            lcm = lcm(lcm, num);
        }

        // Find GCD of all elements in list 'b'
        int gcd = b.get(0);
        for (int num : b) {
            gcd = gcd(gcd, num);
        }

        // Count numbers between LCM and GCD that are multiples of LCM and divisors of GCD
        int count = 0;
        for (int i = lcm; i <= gcd; i += lcm) {
            if (gcd % i == 0) {
                count++;
            }
        }

        return count;
    }

    // Helper method to compute GCD using Euclidean algorithm
    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper method to compute LCM
    private static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a * (b / gcd(a, b)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input sizes
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Read list 'a'
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }

        // Read list 'b'
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            b.add(scanner.nextInt());
        }

        // Compute and print the result
        int total = getTotalX(a, b);
        System.out.println(total);

        scanner.close();
    }

    @Override
    public String toString() {
        return "Solution []";
    }
}