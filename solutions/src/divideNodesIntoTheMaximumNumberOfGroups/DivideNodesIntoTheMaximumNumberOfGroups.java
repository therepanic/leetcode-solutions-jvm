package divideNodesIntoTheMaximumNumberOfGroups;

import java.util.*;

public class DivideNodesIntoTheMaximumNumberOfGroups {

    public static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
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

            if (rootX == rootY) return;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        for (int i = 0; i < n; i++) {
            if (distances[i] == -1 && !isBipartite(i, graph, distances, false)) {
                return -1;
            }
        }
        int max = 0;
        int[] calculated = new int[n];
        UnionFind uf = new UnionFind(n + 1);
        for (int i = 0; i < n; i++) {
            int c = 0;
            Queue<Integer> bfs = new ArrayDeque<>(List.of(i));
            boolean[] visited = new boolean[n];
            visited[i] = true;
            while (!bfs.isEmpty()) {
                int size = bfs.size();
                c++;
                for (int k = 0; k < size; k++) {
                    int node = bfs.poll();
                    for (int v : graph.get(node)) {
                        if (visited[v]) continue;
                        visited[v] = true;
                        uf.union(node, v);
                        bfs.add(v);
                    }
                }
            }
            calculated[uf.find(i)] = Math.max(c, calculated[uf.find(i)]);
        }
        Set<Integer> already = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!already.contains(uf.find(i))) {
                already.add(uf.find(i));
                max += calculated[uf.find(i)];
            }
        }
        return max;
    }

    public boolean isBipartite(int node, List<List<Integer>> graph, int[] distances, boolean signal) {
        if (distances[node] != -1) {
            return distances[node] == (signal ? 1 : 0);
        }
        distances[node] = signal ? 1 : 0;
        for (int v : graph.get(node)) {
            if (!isBipartite(v, graph, distances, !signal)) {
                return false;
            }
        }
        return true;
    }
}
