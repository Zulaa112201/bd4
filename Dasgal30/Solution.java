package Dasgal30;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int solve(List<List<Integer>> shots, List<List<Integer>> players) {
        // Extract and sort all the intervals
        int[] shotStarts = shots.stream().mapToInt(interval -> interval.get(0)).sorted().toArray();
        int[] shotEnds = shots.stream().mapToInt(interval -> interval.get(1)).sorted().toArray();
        
        int count = 0;
        
        for (List<Integer> player : players) {
            int a = player.get(0);
            int b = player.get(1);
            
            // Number of shots that start before or at b
            int left = binarySearchRight(shotStarts, b);
            
            // Number of shots that end before a
            int right = binarySearchLeft(shotEnds, a);
            
            // Total overlapping shots is left - right
            count += (left - right);
        }
        
        return count;
    }
    
    // Find first index where arr[index] > target
    private static int binarySearchRight(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    // Find first index where arr[index] >= target
    private static int binarySearchLeft(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);
        
        List<List<Integer>> shots = new ArrayList<>();
        
        IntStream.range(0, n).forEach(i -> {
            try {
                shots.add(
                    Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        List<List<Integer>> players = new ArrayList<>();
        
        IntStream.range(0, m).forEach(i -> {
            try {
                players.add(
                    Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        int result = Result.solve(shots, players);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}