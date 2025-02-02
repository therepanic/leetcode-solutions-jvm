package satisfiabilityOfEqualityEquations;

public class SatisfiabilityOfEqualityEquations {
    public static boolean equationsPossible(String[] equations) {
        UnionFind equals = new UnionFind(26);
        for (String equat : equations) {
            int first = equat.charAt(0) - 'a';
            int second = equat.charAt(equat.length() - 1) - 'a';
            if (equat.charAt(1) == '=') {
                equals.union(first, second);
            }
        }
        for (String equat : equations) {
            int first = equat.charAt(0) - 'a';
            int second = equat.charAt(equat.length() - 1) - 'a';
            if (equat.charAt(1) == '!'&& (equals.find(first) == equals.find(second))) {
                return false;
            }
        }
        return true;
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
