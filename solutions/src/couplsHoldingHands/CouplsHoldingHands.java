package couplsHoldingHands;

public class CouplsHoldingHands {
    public int minSwapsCouples(int[] row) {
        UnionFind unionFind = new UnionFind(row.length);
        for (int i = 0; i < row.length; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        int count = 0;
        for (int i = 0; i < row.length / 2; i++) {
            if (i != unionFind.find(i)) count++;
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
