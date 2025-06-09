package Dasgal26;
import java.io.*;
import java.util.*;

public class Solution {
    static final int MOD = 1000000007;
    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        size = new int[n + 1];
        
        // Initialize DSU
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        // Process edges
        for (int i = 0; i < n - 1; i++) {
            String[] parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            char c = parts[2].charAt(0);
            
            if (c == 'b') {
                union(u, v);
            }
        }
        
        // Calculate total triplets
        long total = n * (n - 1L) * (n - 2L) / 6;
        total %= MOD;
        
        // Calculate invalid triplets
        long invalid = 0;
        Set<Integer> roots = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            roots.add(find(i));
        }
        
        for (int root : roots) {
            long s = size[root];
            if (s >= 3) {
                invalid += s * (s - 1) * (s - 2) / 6;
                invalid %= MOD;
            }
            if (s >= 2) {
                invalid += s * (s - 1) / 2 * (n - s);
                invalid %= MOD;
            }
        }
        
        long result = (total - invalid) % MOD;
        if (result < 0) result += MOD;
        System.out.println(result);
    }
    
    static int find(int u) {
        while (parent[u] != u) {
            parent[u] = parent[parent[u]]; // Path compression
            u = parent[u];
        }
        return u;
    }
    
    static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) return;
        
        // Union by size
        if (size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
    }
}