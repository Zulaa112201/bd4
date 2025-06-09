package Dasgal21;

import java.util.*;

public class Solution {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Create frequency map
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : strings) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
        
        // Process queries
        List<Integer> results = new ArrayList<>();
        for (String query : queries) {
            results.add(frequencyMap.getOrDefault(query, 0));
        }
        
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input strings
        int stringsCount = scanner.nextInt();
        scanner.nextLine(); // consume newline
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < stringsCount; i++) {
            strings.add(scanner.nextLine());
        }
        
        // Read queries
        int queriesCount = scanner.nextInt();
        scanner.nextLine(); // consume newline
        List<String> queries = new ArrayList<>();
        for (int i = 0; i < queriesCount; i++) {
            queries.add(scanner.nextLine());
        }
        
        // Calculate and print results
        List<Integer> results = matchingStrings(strings, queries);
        for (int result : results) {
            System.out.println(result);
        }
        
        scanner.close();
    }
}