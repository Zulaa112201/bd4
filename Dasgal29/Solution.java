package Dasgal29;

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node(1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        for (int i = 0; i < n; i++) {
            String[] children = br.readLine().split(" ");
            int left = Integer.parseInt(children[0]);
            int right = Integer.parseInt(children[1]);
            Node current = queue.poll();
            
            if (left != -1) {
                current.left = new Node(left);
                queue.add(current.left);
            }
            if (right != -1) {
                current.right = new Node(right);
                queue.add(current.right);
            }
        }
        
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            swapNodes(root, k, 1);
            List<Integer> result = new ArrayList<>();
            inOrder(root, result);
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    private static void swapNodes(Node root, int k, int depth) {
        if (root == null) {
            return;
        }
        if (depth % k == 0) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        swapNodes(root.left, k, depth + 1);
        swapNodes(root.right, k, depth + 1);
    }
    
    private static void inOrder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        result.add(root.data);
        inOrder(root.right, result);
    }
}