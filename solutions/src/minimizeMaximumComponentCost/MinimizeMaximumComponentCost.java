package minimizeMaximumComponentCost;

public class MinimizeMaximumComponentCost {

    public int minCost(int n, int[][] edges, int k) {
        int l = 0;
        int r = 0;
        for (int[] edge : edges) {
            r = Math.max(edge[2], r);
        }
        int ans = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (can(n, edges, mid, k)) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean can(int n, int[][] edges, int limit, int k) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            if (edge[2] <= limit) {
                dsu.union(edge[0], edge[1]);
            }
        }
        return dsu.count() <= k;
    }

    static class DSU {
        int[] parent, rank;
        int comp;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            comp = n;
        }
        int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }
        void union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return;
            if (rank[a] < rank[b]) parent[a] = b;
            else if (rank[a] > rank[b]) parent[b] = a;
            else { parent[b] = a; rank[a]++; }
            comp--;
        }
        int count() { return comp; }
    }

}
