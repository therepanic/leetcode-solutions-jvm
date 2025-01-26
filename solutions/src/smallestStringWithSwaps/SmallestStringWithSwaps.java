package smallestStringWithSwaps;

import java.util.*;

public class SmallestStringWithSwaps {
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] sChars = s.toCharArray();
        UnionFind uf = new UnionFind(sChars.length);

        for (List<Integer> pair : pairs) {
            int a = pair.get(0);
            int b = pair.get(1);
            uf.union(a, b);
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            int root = uf.find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> group : groups.values()) {
            List<Character> characters = new ArrayList<>();
            List<Integer> indexes = new ArrayList<>();
            for (int groupIndex : group) {
                characters.add(sChars[groupIndex]);
                indexes.add(groupIndex);
            }
            Collections.sort(characters);
            Collections.sort(indexes);
            for (int i = 0; i < indexes.size(); i++) {
                sChars[indexes.get(i)] = characters.get(i);
            }
        }
        return String.valueOf(sChars);
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
