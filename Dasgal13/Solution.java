package Dasgal13;

import java.util.*;

public class Solution {

    public static int countingValleys(int steps, String path) {
        int altitude = 0;
        int valleyCount = 0;
        boolean inValley = false;

        for (char step : path.toCharArray()) {
            if (step == 'U') {
                altitude++;
            } else {
                altitude--;
            }

            // Check if we just came out of a valley
            if (altitude == 0 && inValley) {
                valleyCount++;
                inValley = false;
            }

            // Check if we entered a valley
            if (altitude < 0 && !inValley) {
                inValley = true;
            }
        }

        return valleyCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of steps
        int steps = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Read path string
        String path = scanner.nextLine();
        
        // Calculate and print result
        int result = countingValleys(steps, path);
        System.out.println(result);
        
        scanner.close();
    }
}