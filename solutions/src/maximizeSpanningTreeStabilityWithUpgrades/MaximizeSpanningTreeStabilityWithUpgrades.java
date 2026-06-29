package maximizeSpanningTreeStabilityWithUpgrades;

import java.util.*;

public class MaximizeSpanningTreeStabilityWithUpgrades {

    public int maxStability(int n, int[][] edges, int k) {
        Arrays.sort(edges, (p1, p2) -> {
            if (p1[3] != p2[3]) {
                return Integer.compare(p1[3], p2[3]);
            } else {
                return Integer.compare(p1[2], p2[2]);
            }
        });
        DSU dsu = new DSU(n);
        int used = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i;
        for (i = edges.length - 1; i >= 0 && edges[i][3] == 1; i--) {
            if (dsu.union(edges[i][0], edges[i][1])) {
                used++;
                heap.add(edges[i][2]);
            } else {
                return -1;
            }
        }
        PriorityQueue<Integer> optional = new PriorityQueue<>();
        while (i >= 0 && used != n - 1) {
            if (dsu.union(edges[i][0], edges[i][1])) {
                used++;
                optional.add(edges[i][2]);
            }
            i--;
        }
        if (used != n - 1) {
            return -1;
        }
        while (!optional.isEmpty()) {
            if (k > 0) {
                heap.add(optional.poll() * 2);
                k--;
            } else {
                heap.add(optional.poll());
            }
        }
        return heap.poll();
    }

        static class DSU {
            private int[] parent;
            private int[] rank;

            public DSU(int size) {
                parent = new int[size];
                rank = new int[size];
                for (int i = 0; i < size; i++) {
                    parent[i] = i;
                    rank[i] = 0;
                }
            }

            public int find(int i) {
                if (parent[i] == i) {
                    return i;
                }
                return parent[i] = find(parent[i]);
            }

            public boolean union(int i, int j) {
                int rootI = find(i);
                int rootJ = find(j);

                if (rootI == rootJ) {
                    return false;
                }

                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else {
                    parent[rootJ] = rootI;
                    rank[rootI]++;
                }
                return true;
            }
    }
}
