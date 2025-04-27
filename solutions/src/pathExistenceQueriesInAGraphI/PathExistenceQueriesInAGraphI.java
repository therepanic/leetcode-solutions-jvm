package pathExistenceQueriesInAGraphI;

public class PathExistenceQueriesInAGraphI {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] answer = new boolean[queries.length];
        DSU dsu = new DSU(n);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                dsu.union(i - 1, i);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i] = dsu.find(queries[i][0]) == dsu.find(queries[i][1]);
        }
        return answer;
    }

    static class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
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

        public void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return;

            if (rank[ra] < rank[rb]) {
                parent[ra] = rb;
            } else if (rank[ra] > rank[rb]) {
                parent[rb] = ra;
            } else {
                parent[rb] = ra;
                rank[ra]++;
            }
        }
    }
}
