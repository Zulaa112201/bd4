package Dasgal16;

import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;
        
        for (int layer = 0; layer < layers; layer++) {
            List<Integer> ring = new ArrayList<>();
            
            // Extract top row (left to right)
            for (int j = layer; j < n - layer; j++) {
                ring.add(matrix.get(layer).get(j));
            }
            
            // Extract right column (top to bottom, excluding first element)
            for (int i = layer + 1; i < m - layer; i++) {
                ring.add(matrix.get(i).get(n - 1 - layer));
            }
            
            // Extract bottom row (right to left, excluding first element)
            if (m - 1 - layer != layer) {
                for (int j = n - 2 - layer; j >= layer; j--) {
                    ring.add(matrix.get(m - 1 - layer).get(j));
                }
            }
            
            // Extract left column (bottom to top, excluding first and last elements)
            if (n - 1 - layer != layer) {
                for (int i = m - 2 - layer; i > layer; i--) {
                    ring.add(matrix.get(i).get(layer));
                }
            }
            
            // Rotate the ring
            int rotations = r % ring.size();
            Collections.rotate(ring, -rotations);
            
            // Put the rotated ring back into the matrix
            int index = 0;
            
            // Top row
            for (int j = layer; j < n - layer; j++) {
                matrix.get(layer).set(j, ring.get(index++));
            }
            
            // Right column
            for (int i = layer + 1; i < m - layer; i++) {
                matrix.get(i).set(n - 1 - layer, ring.get(index++));
            }
            
            // Bottom row
            if (m - 1 - layer != layer) {
                for (int j = n - 2 - layer; j >= layer; j--) {
                    matrix.get(m - 1 - layer).set(j, ring.get(index++));
                }
            }
            
            // Left column
            if (n - 1 - layer != layer) {
                for (int i = m - 2 - layer; i > layer; i--) {
                    matrix.get(i).set(layer, ring.get(index++));
                }
            }
        }
        
        // Print the rotated matrix
        for (List<Integer> row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read matrix dimensions and rotation count
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        
        // Read matrix
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(scanner.nextInt());
            }
            matrix.add(row);
        }
        
        // Perform rotation
        matrixRotation(matrix, r);
        
        scanner.close();
    }
}