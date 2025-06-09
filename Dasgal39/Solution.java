package Dasgal39;

import java.io.*;
import java.util.*;

public class Solution {
    public static int makingAnagrams(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        // Count frequencies for first string
        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }
        
        // Count frequencies for second string
        for (char c : s2.toCharArray()) {
            freq2[c - 'a']++;
        }
        
        int deletions = 0;
        // Calculate absolute differences between frequencies
        for (int i = 0; i < 26; i++) {
            deletions += Math.abs(freq1[i] - freq2[i]);
        }
        
        return deletions;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s1 = br.readLine();
        String s2 = br.readLine();
        
        int result = makingAnagrams(s1, s2);
        bw.write(String.valueOf(result));
        
        bw.flush();
        bw.close();
        br.close();
    }
}