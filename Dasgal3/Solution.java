import java.util.*;

public class Solution {

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // If the kangaroo starting behind is slower or same speed, they'll never catch up
        if ( (x1 > x2 && v1 >= v2) || (x2 > x1 && v2 >= v1) ) {
            return "NO";
        }
        
        // Check if the relative distance is divisible by relative speed
        if (x1 < x2) {
            return ( (x2 - x1) % (v1 - v2) == 0 ) ? "YES" : "NO";
        } else {
            return ( (x1 - x2) % (v2 - v1) == 0 ) ? "YES" : "NO";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input values
        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();
        
        // Determine if kangaroos meet
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
        
        scanner.close();
    }
}