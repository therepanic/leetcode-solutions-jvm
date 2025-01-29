package lexicographicallySmallestEquivalentString;

public class LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] base = baseStr.toCharArray();
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        UnionFind uf = new UnionFind(26);
        char[] minChar = new char[26];

        for (char c = 'a'; c <= 'z'; c++) {
            minChar[c - 'a'] = c;
        }

        for (int i = 0; i < s1.length(); i++) {
            int root1 = uf.find(s1Chars[i] - 'a');
            int root2 = uf.find(s2Chars[i] - 'a');
            uf.union(root1, root2);

            int newRoot = uf.find(root1);

            minChar[newRoot] = (char) Math.min(minChar[root1], minChar[root2]);
        }

        for (int i = 0; i < base.length; i++) {
            base[i] = minChar[uf.find(base[i] - 'a')];
        }
        return String.valueOf(base);
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
