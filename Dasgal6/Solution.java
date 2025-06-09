package Dasgal6;

import java.util.*;

public class Solution {

    public static int birthday(List<Integer> chocolate, int day, int month) {
        int count = 0;
        int n = chocolate.size();
        
        // Check edge case where month is longer than the chocolate bar
        if (month > n) {
            return 0;
        }
        
        // Calculate initial sum for the first segment
        int sum = 0;
        for (int i = 0; i < month; i++) {
            sum += chocolate.get(i);
        }
        if (sum == day) {
            count++;
        }
        
        // Slide the window across the chocolate bar
        for (int i = month; i < n; i++) {
            sum += chocolate.get(i) - chocolate.get(i - month);
            if (sum == day) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of squares in the chocolate bar
        int n = scanner.nextInt();
        
        // Read numbers on each square
        List<Integer> chocolate = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            chocolate.add(scanner.nextInt());
        }
        
        // Read day and month of birth
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        
        // Calculate and print the result
        int result = birthday(chocolate, day, month);
        System.out.println(result);
        
        scanner.close();
    }
}