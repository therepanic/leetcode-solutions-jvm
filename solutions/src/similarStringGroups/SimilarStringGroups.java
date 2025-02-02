package similarStringGroups;

import java.util.HashSet;
import java.util.Set;

public class SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        UnionFind uf = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                String a = strs[i];
                String b = strs[j];

                if (isSimilar(a, b)) {
                    uf.union(i, j);
                }
            }
        }
        Set<Integer> groups = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            groups.add(uf.find(i));
        }
        return groups.size();
    }

    public boolean isSimilar(String a, String b) {
        if (a.length() != b.length()) return false;
        int c = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) c++;
            if (c > 2) return false;
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
