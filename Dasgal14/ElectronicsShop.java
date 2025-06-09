package Dasgal14;

import java.util.*;

public class ElectronicsShop {

    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int maxSpent = -1;  // Default value if no affordable combination
        
        // Check all possible combinations
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                int total = keyboard + drive;
                if (total <= b && total > maxSpent) {
                    maxSpent = total;
                }
            }
        }
        
        return maxSpent;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read budget, keyboard count, and drive count
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        // Read keyboard prices
        int[] keyboards = new int[n];
        for (int i = 0; i < n; i++) {
            keyboards[i] = scanner.nextInt();
        }
        
        // Read drive prices
        int[] drives = new int[m];
        for (int i = 0; i < m; i++) {
            drives[i] = scanner.nextInt();
        }
        
        // Calculate and print result
        int result = getMoneySpent(keyboards, drives, b);
        System.out.println(result);
        
        scanner.close();
    }
}