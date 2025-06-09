import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(parts[i]);
        }
        
        int[] diff = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            if (t[i] >= n) {
                continue; // this student will never be satisfied
            }
            int a = (i + 1) % n;
            int b = (i - t[i] + n) % n;
            
            if (a <= b) {
                diff[a]++;
                diff[b + 1]--;
            } else {
                diff[a]++;
                diff[n]--;
                diff[0]++;
                diff[b + 1]--;
            }
        }
        
        int max = 0;
        int current = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            if (current > max) {
                max = current;
                result = i;
            }
        }
        
        System.out.println(result + 1); // converting to 1-based index
    }
}