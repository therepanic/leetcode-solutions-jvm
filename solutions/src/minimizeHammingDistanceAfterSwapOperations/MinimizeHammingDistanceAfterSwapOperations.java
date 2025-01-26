package minimizeHammingDistanceAfterSwapOperations;

import java.util.*;

public class MinimizeHammingDistanceAfterSwapOperations {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        UnionFind uf = new UnionFind(source.length);
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            int root = uf.find(i);
            graph.computeIfAbsent(root, k -> new HashSet<>()).add(i);
        }
        int count = 0;
        for (Set<Integer> nodes : graph.values()) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int node : nodes) {
                countMap.put(source[node], countMap.getOrDefault(source[node], 0) + 1);
            }
            for (int node : nodes) {
                if (!countMap.containsKey(target[node])) {
                    count++;
                } else {
                    if (countMap.get(target[node]) > 1) {
                        countMap.put(target[node], countMap.get(target[node]) - 1);
                    } else {
                        countMap.remove(target[node]);
                    }
                }
            }
        }
        return count;
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
