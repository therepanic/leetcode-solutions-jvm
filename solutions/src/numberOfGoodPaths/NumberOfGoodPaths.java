package numberOfGoodPaths;

import java.util.*;

public class NumberOfGoodPaths {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        DSU dsu = new DSU(n);
        List<List<Integer>> graph = new ArrayList<>();
        Map<Integer, List<Integer>> values = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            values.computeIfAbsent(vals[i], _ -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int ans = n;
        for (var entry : values.entrySet()) {
            for (int v1 : entry.getValue()) {
                for (int v2 : graph.get(v1)) {
                    if (vals[v2] <= vals[v1]) {
                        dsu.union(v1, v2);
                    }
                }
            }
            Map<Integer, Integer> count = new HashMap<>();
            for (int node : entry.getValue()) {
                int root = dsu.find(node);
                count.put(root, count.getOrDefault(root, 0) + 1);
            }
            for (int k : count.values()) {
                ans += k * (k - 1) / 2;
            }
        }
        return ans;
    }

    static class DSU {
        private final int[] parent;
        private final int[] size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            return true;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
