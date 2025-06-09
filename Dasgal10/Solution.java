package Dasgal10;

import java.util.*;

public class Solution {

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int total = 0;
        
        // Calculate total cost of shared items
        for (int i = 0; i < bill.size(); i++) {
            if (i != k) {  // Exclude the item Anna didn't eat
                total += bill.get(i);
            }
        }
        
        int annaShare = total / 2;
        
        if (annaShare == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - annaShare);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n and k
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        // Read the bill items
        List<Integer> bill = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bill.add(scanner.nextInt());
        }
        
        // Read the amount Brian charged Anna
        int b = scanner.nextInt();
        
        // Calculate and print the result
        bonAppetit(bill, k, b);
        
        scanner.close();
    }
}