package Dasgal11;

import java.util.*;

public class Solution {

    public static int sockMerchant(int n, int[] ar) {
        // Create a frequency map to count occurrences of each color
        Map<Integer, Integer> colorCounts = new HashMap<>();
        
        // Count each color's occurrences
        for (int color : ar) {
            colorCounts.put(color, colorCounts.getOrDefault(color, 0) + 1);
        }
        
        // Calculate total pairs
        int totalPairs = 0;
        for (int count : colorCounts.values()) {
            totalPairs += count / 2;
        }
        
        return totalPairs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of socks
        int n = scanner.nextInt();
        
        // Read sock colors
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        
        // Calculate and print result
        int result = sockMerchant(n, ar);
        System.out.println(result);
        
        scanner.close();
    }
}