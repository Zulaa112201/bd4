package Dasgal27;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] plants = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            plants[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        int maxDays = 0;

        for (int plant : plants) {
            int days = 0;
            while (!stack.isEmpty() && stack.peek()[0] >= plant) {
                days = Math.max(days, stack.pop()[1]);
            }
            if (!stack.isEmpty()) {
                days += 1;
            } else {
                days = 0;
            }
            maxDays = Math.max(maxDays, days);
            stack.push(new int[]{plant, days});
        }

        System.out.println(maxDays);
    }
}