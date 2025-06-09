package Dasgal28;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int maxXOR = 0;

        for (int num : arr) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                int currentXOR = top ^ num;
                if (currentXOR > maxXOR) {
                    maxXOR = currentXOR;
                }
                if (num < top) {
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(num);
        }

        System.out.println(maxXOR);
    }
}