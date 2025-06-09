package Dasgal12;

import java.util.*;

public class Solution {

    public static int pageCount(int n, int p) {
        // Calculate turns from front and back
        int fromFront = p / 2;
        int fromBack = (n / 2) - (p / 2);
        
        // Return the minimum of the two
        return Math.min(fromFront, fromBack);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read total pages (n) and target page (p)
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        
        // Calculate and print result
        int result = pageCount(n, p);
        System.out.println(result);
        
        scanner.close();
    }
}