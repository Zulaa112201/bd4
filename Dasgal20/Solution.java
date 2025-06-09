package Dasgal20;

import java.util.*;

public class Solution {

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        Set<Integer> weights = new HashSet<>();
        char prev = ' ';
        int currentLength = 0;
        
        // Calculate all possible weights
        for (char c : s.toCharArray()) {
            if (c == prev) {
                currentLength++;
            } else {
                currentLength = 1;
                prev = c;
            }
            int weight = (c - 'a' + 1) * currentLength;
            weights.add(weight);
        }
        
        // Process queries
        List<String> results = new ArrayList<>();
        for (int query : queries) {
            results.add(weights.contains(query) ? "Yes" : "No");
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int queriesCount = scanner.nextInt();
        
        List<Integer> queries = new ArrayList<>();
        for (int i = 0; i < queriesCount; i++) {
            queries.add(scanner.nextInt());
        }
        
        List<String> results = weightedUniformStrings(s, queries);
        for (String result : results) {
            System.out.println(result);
        }
        
        scanner.close();
    }
}