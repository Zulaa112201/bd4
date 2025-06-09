package Dasgal37;

import java.io.*;

public class Solution {
    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Check if removing left character makes palindrome
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }
                // Check if removing right character makes palindrome
                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }
                // If neither works, return -1
                return -1;
            }
            left++;
            right--;
        }
        // String is already a palindrome
        return -1;
    }
    
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String s = br.readLine();
            int result = palindromeIndex(s);
            bw.write(String.valueOf(result));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}