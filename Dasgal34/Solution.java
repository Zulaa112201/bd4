import java.io.*;
import java.util.*;

public class Solution {
    static class Edge {
        int to;
        Edge(int to) {
            this.to = to;
        }
    }

    static int n, q;
    static List<Edge>[] tree;
    static int[] parent, depth, heavy, head, pos, value;
    static int currentPos;
    static SegmentTree segTree;

    static class SegmentTree {
        int[] tree;
        int size;

        SegmentTree(int size) {
            this.size = size;
            tree = new int[2 * size];
        }

        void update(int pos, int val) {
            pos += size;
            tree[pos] = val;
            for (pos >>= 1; pos >= 1; pos >>= 1) {
                tree[pos] = Math.max(tree[2 * pos], tree[2 * pos + 1]);
            }
        }

        int query(int l, int r) {
            int res = 0;
            for (l += size, r += size; l < r; l >>= 1, r >>= 1) {
                if ((l & 1) == 1) res = Math.max(res, tree[l++]);
                if ((r & 1) == 1) res = Math.max(res, tree[--r]);
            }
            return res;
        }
    }

    static int dfs(int u) {
        int size = 1;
        int maxChildSize = 0;
        for (Edge e : tree[u]) {
            int v = e.to;
            if (v != parent[u]) {
                parent[v] = u;
                depth[v] = depth[u] + 1;
                int childSize = dfs(v);
                size += childSize;
                if (childSize > maxChildSize) {
                    maxChildSize = childSize;
                    heavy[u] = v;
                }
            }
        }
        return size;
    }

    static void decompose(int u, int h) {
        head[u] = h;
        pos[u] = currentPos++;
        if (heavy[u] != -1) {
            decompose(heavy[u], h);
        }
        for (Edge e : tree[u]) {
            int v = e.to;
            if (v != parent[u] && v != heavy[u]) {
                decompose(v, v);
            }
        }
    }

    static int query(int a, int b) {
        int res = 0;
        while (head[a] != head[b]) {
            if (depth[head[a]] > depth[head[b]]) {
                int temp = a;
                a = b;
                b = temp;
            }
            res = Math.max(res, segTree.query(pos[head[b]], pos[b] + 1));
            b = parent[head[b]];
        }
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        res = Math.max(res, segTree.query(pos[a], pos[b] + 1));
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        q = Integer.parseInt(parts[1]);

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            tree[u].add(new Edge(v));
            tree[v].add(new Edge(u));
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        Arrays.fill(heavy, -1);
        head = new int[n];
        pos = new int[n];
        value = new int[n];

        dfs(0);
        currentPos = 0;
        decompose(0, 0);

        segTree = new SegmentTree(n);

        for (int i = 0; i < q; i++) {
            parts = br.readLine().split(" ");
            int type = Integer.parseInt(parts[0]);
            if (type == 1) {
                int u = Integer.parseInt(parts[1]);
                int x = Integer.parseInt(parts[2]);
                segTree.update(pos[u], x);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                System.out.println(query(u, v));
            }
        }
    }
}