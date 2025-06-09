package Dasgal19;

import java.util.*;

public class Solution {

    public static String pangrams(String s) {
        // Create a set to track seen letters
        Set<Character> letters = new HashSet<>();
        
        // Convert to lowercase and process each character
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            }
        }
        
        // Check if all 26 letters are present
        return letters.size() == 26 ? "pangram" : "not pangram";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(pangrams(s));
        scanner.close();
    }
}