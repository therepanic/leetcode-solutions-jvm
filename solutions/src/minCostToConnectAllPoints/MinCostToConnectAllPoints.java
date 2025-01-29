package minCostToConnectAllPoints;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        UnionFind uf = new UnionFind(points.length);
        List<int[]> graph = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                graph.add(new int[] {i, j, (Math.abs(points[i][0] - points[j][0])) + Math.abs(points[i][1] - points[j][1])});
            }
        }
        graph.sort(Comparator.comparing(p -> p[2]));
        int total = 0;
        int used = 0;
        for (int[] edge : graph) {
            if (uf.find(edge[0]) != uf.find(edge[1])) {
                uf.union(edge[0], edge[1]);
                total += edge[2];
                used++;
            }
            if (used == points.length - 1) break;
        }
        return total;
    }

    static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}
