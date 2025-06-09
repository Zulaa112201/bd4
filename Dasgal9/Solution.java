package Dasgal9;

import java.util.*;

public class Solution {

    public static String dayOfProgrammer(int year) {
        if (year == 1918) {
            // Special case: transition year
            return "26.09.1918";
        } else if (isLeapYear(year)) {
            return "12.09." + year;
        } else {
            return "13.09." + year;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year < 1918) {
            // Julian calendar
            return year % 4 == 0;
        } else {
            // Gregorian calendar
            return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        System.out.println(dayOfProgrammer(year));
        scanner.close();
    }
}