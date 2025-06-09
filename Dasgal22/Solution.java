package Dasgal22;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        long[] diff = new long[n + 2]; // Using long to prevent integer overflow
        
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();
            
            diff[a] += k;
            if (b + 1 <= n) {
                diff[b + 1] -= k;
            }
        }
        
        long maxValue = 0;
        long current = 0;
        for (int i = 1; i <= n; i++) {
            current += diff[i];
            if (current > maxValue) {
                maxValue = current;
            }
        }
        
        System.out.println(maxValue);
        scanner.close();
    }
}