package Dasgal23;

import java.util.*;
import java.io.*;

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
    static class QueueNode {
        Node node;
        int hd; // horizontal distance
        
        QueueNode(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
    public static void topView(Node root) {
        if (root == null) return;
        
        // TreeMap to store nodes sorted by horizontal distance
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<QueueNode> queue = new LinkedList<>();
        
        queue.add(new QueueNode(root, 0));
        
        while (!queue.isEmpty()) {
            QueueNode current = queue.poll();
            int hd = current.hd;
            Node node = current.node;
            
            // Only add to map if this is the first node at this hd
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }
            
            if (node.left != null) {
                queue.add(new QueueNode(node.left, hd - 1));
            }
            
            if (node.right != null) {
                queue.add(new QueueNode(node.right, hd + 1));
            }
        }
        
        // Print the values in order of horizontal distance
        for (int value : map.values()) {
            System.out.print(value + " ");
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}