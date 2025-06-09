package Dasgal17;

import java.util.*;

public class Solution {

    public static int marsExploration(String s) {
        int changed = 0;
        for (int i = 0; i < s.length(); i++) {
            char expected = (i % 3 == 1) ? 'O' : 'S';
            if (s.charAt(i) != expected) {
                changed++;
            }
        }
        return changed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(marsExploration(s));
        scanner.close();
    }
}