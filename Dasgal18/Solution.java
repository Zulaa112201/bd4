package Dasgal18;

import java.util.*;

public class Solution {

    public static String hackerrankInString(String s) {
        String target = "hackerrank";
        int targetIndex = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target.charAt(targetIndex)) {
                targetIndex++;
                if (targetIndex == target.length()) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        for (int i = 0; i < q; i++) {
            String s = scanner.nextLine();
            System.out.println(hackerrankInString(s));
        }
        
        scanner.close();
    }
}