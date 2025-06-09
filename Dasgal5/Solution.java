package Dasgal5;

import java.util.*;

public class Solution {

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int min = scores.get(0);
        int max = scores.get(0);
        int minCount = 0;
        int maxCount = 0;

        for (int i = 1; i < scores.size(); i++) {
            int current = scores.get(i);
            if (current > max) {
                max = current;
                maxCount++;
            } else if (current < min) {
                min = current;
                minCount++;
            }
        }

        return Arrays.asList(maxCount, minCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of games
        int n = scanner.nextInt();

        // Read scores
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            scores.add(scanner.nextInt());
        }

        // Get the record breaking counts
        List<Integer> result = breakingRecords(scores);

        // Print the result
        System.out.println(result.get(0) + " " + result.get(1));

        scanner.close();
    }
}