package Dasgal8;

import java.util.*;

public class Solution {

    public static int migratoryBirds(List<Integer> arr) {
        // Create a frequency array (bird types are 1-5)
        int[] freq = new int[6]; // Using 1-based indexing
        
        // Count frequencies of each bird type
        for (int bird : arr) {
            freq[bird]++;
        }
        
        int maxFreq = 0;
        int mostCommonBird = 1; // Default to smallest ID
        
        // Find the bird type with highest frequency
        for (int i = 1; i <= 5; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                mostCommonBird = i;
            }
        }
        
        return mostCommonBird;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of sightings
        int arrCount = scanner.nextInt();
        
        // Read bird sightings
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arrCount; i++) {
            arr.add(scanner.nextInt());
        }
        
        // Calculate and print result
        int result = migratoryBirds(arr);
        System.out.println(result);
        
        scanner.close();
    }
}