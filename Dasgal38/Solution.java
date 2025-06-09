package Dasgal38;

import java.io.*;
import java.util.*;

public class Solution {
    public static int anagram(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }
        
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);
        
        int[] count = new int[26];
        
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
        }
        
        int changes = 0;
        for (int i : count) {
            changes += Math.abs(i);
        }
        
        return changes / 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String s = br.readLine();
            int result = anagram(s);
            bw.write(String.valueOf(result));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}