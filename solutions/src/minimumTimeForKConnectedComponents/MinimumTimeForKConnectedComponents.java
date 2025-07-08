package minimumTimeForKConnectedComponents;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumTimeForKConnectedComponents {

    public int minTime(int n, int[][] edges, int k) {
        int test = n;
        DSU testDsu = new DSU(n);
        for (int[] edge : edges) {
            if (testDsu.union(edge[0], edge[1])) {
                test--;
            }
        }
        if (test >= k) return 0;
        Arrays.sort(edges, Comparator.comparingInt(p -> p[2]));
        DSU dsu = new DSU(n);
        int nodes = n;
        for (int i = edges.length - 1; i >= 0; i--) {
            if (dsu.union(edges[i][0], edges[i][1])) {
                nodes--;
                if (nodes < k) {
                    return edges[i][2];
                }
            }
        }
        return 0;
    }

    static class DSU {

        private int[] parent;
        private int[] size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int a) {
            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) return false;

            if (size[rootA] < size[rootB]) {
                int temp = rootA;
                rootA = rootB;
                rootB = temp;
            }

            parent[rootB] = rootA;
            size[rootA] += size[rootB];
            return true;
        }
    }

}
