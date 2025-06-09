package Dasgal15;

import java.util.*;

public class Solution {

    public static String catAndMouse(int x, int y, int z) {
        int catADistance = Math.abs(x - z);
        int catBDistance = Math.abs(y - z);
        
        if (catADistance < catBDistance) {
            return "Cat A";
        } else if (catBDistance < catADistance) {
            return "Cat B";
        } else {
            return "Mouse C";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            System.out.println(catAndMouse(x, y, z));
        }
        
        scanner.close();
    }
}