package Dasgal40;

import java.io.*;
import java.util.*;

public class Solution {
    public static String gameOfThrones(String s) {
        int[] freq = new int[26];
        
        // Count character frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return "NO";
            }
        }
        
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        String result = gameOfThrones(s);
        bw.write(result);
        
        bw.flush();
        bw.close();
        br.close();
    }
}