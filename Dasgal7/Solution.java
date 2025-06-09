package Dasgal7;

import java.util.*;

public class Solution {

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int count = 0;
        
        // Iterate through all possible pairs (i, j) where i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar.get(i) + ar.get(j)) % k == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n and k
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        // Read the array
        List<Integer> ar = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ar.add(scanner.nextInt());
        }
        
        // Calculate and print the result
        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result);
        
        scanner.close();
    }
}