package checkingExistenceOfEdgeLengthLimitedPaths;

import java.util.Arrays;
import java.util.Comparator;

public class CheckingExistenceOfEdgeLengthLimitedPaths {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[][] newQueries = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++) {
            newQueries[i] = new int[] {queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(edgeList, Comparator.comparingInt(p -> p[2]));
        Arrays.sort(newQueries, Comparator.comparingInt(p -> p[2]));
        DSU dsu = new DSU(n);
        int it = 0;
        boolean[] ans = new boolean[newQueries.length];
        for (int i = 0; i < newQueries.length; i++) {
            int[] query = newQueries[i];
            while (it < edgeList.length && edgeList[it][2] < query[2]) {
                dsu.union(edgeList[it][0], edgeList[it][1]);
                it++;
            }
            ans[query[3]] = dsu.isConnected(query[0], query[1]);
        }
        return ans;
    }
    public static class DSU {
        private final int[] parent;
        private final int[] rank;

        public DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return false;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            return true;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
