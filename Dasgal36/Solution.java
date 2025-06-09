package Dasgal36;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class AhoCorasickNode {
    Map<Character, AhoCorasickNode> children = new HashMap<>();
    AhoCorasickNode suffixLink = null;
    AhoCorasickNode outputLink = null;
    List<Integer> outputs = new ArrayList<>();
    long health = 0;
}

public class Solution {
    private static AhoCorasickNode buildTrie(String[] genes, int[] health) {
        AhoCorasickNode root = new AhoCorasickNode();
        
        for (int i = 0; i < genes.length; i++) {
            AhoCorasickNode current = root;
            for (char c : genes[i].toCharArray()) {
                current = current.children.computeIfAbsent(c, k -> new AhoCorasickNode());
            }
            current.outputs.add(i);
            current.health += health[i];
        }
        
        Queue<AhoCorasickNode> queue = new LinkedList<>();
        root.suffixLink = root;
        queue.add(root);
        
        while (!queue.isEmpty()) {
            AhoCorasickNode current = queue.poll();
            
            for (Map.Entry<Character, AhoCorasickNode> entry : current.children.entrySet()) {
                char c = entry.getKey();
                AhoCorasickNode child = entry.getValue();
                
                AhoCorasickNode suffix = current.suffixLink;
                while (suffix != root && !suffix.children.containsKey(c)) {
                    suffix = suffix.suffixLink;
                }
                
                if (suffix.children.containsKey(c) && suffix.children.get(c) != child) {
                    child.suffixLink = suffix.children.get(c);
                } else {
                    child.suffixLink = root;
                }
                
                queue.add(child);
            }
            
            if (current.suffixLink.outputs.size() > 0) {
                current.outputLink = current.suffixLink;
            } else if (current.suffixLink.outputLink != null) {
                current.outputLink = current.suffixLink.outputLink;
            }
        }
        
        return root;
    }
    
    private static long calculateHealth(AhoCorasickNode root, String d, int first, int last, int[] health, String[] genes) {
        long totalHealth = 0;
        AhoCorasickNode current = root;
        
        for (char c : d.toCharArray()) {
            while (current != root && !current.children.containsKey(c)) {
                current = current.suffixLink;
            }
            
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            }
            
            AhoCorasickNode outputNode = current;
            while (outputNode != null) {
                for (int index : outputNode.outputs) {
                    if (index >= first && index <= last) {
                        totalHealth += health[index];
                    }
                }
                outputNode = outputNode.outputLink;
            }
        }
        
        return totalHealth;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] genes = br.readLine().split(" ");
        int[] health = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        AhoCorasickNode root = buildTrie(genes, health);
        
        int s = Integer.parseInt(br.readLine());
        long minHealth = Long.MAX_VALUE;
        long maxHealth = Long.MIN_VALUE;
        
        for (int i = 0; i < s; i++) {
            String[] query = br.readLine().split(" ");
            int first = Integer.parseInt(query[0]);
            int last = Integer.parseInt(query[1]);
            String d = query[2];
            
            long currentHealth = calculateHealth(root, d, first, last, health, genes);
            
            minHealth = Math.min(minHealth, currentHealth);
            maxHealth = Math.max(maxHealth, currentHealth);
        }
        
        System.out.println(minHealth + " " + maxHealth);
    }
}