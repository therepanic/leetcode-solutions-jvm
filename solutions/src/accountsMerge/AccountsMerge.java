package accountsMerge;

import java.util.*;

public class AccountsMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> strCountMap = new HashMap<>();
        Map<Integer, String> countStrMap = new HashMap<>();
        Map<String, List<String>> wordNameMap = new HashMap<>();

        int c = 0;

        for (List<String> acc : accounts) {
            String name = acc.getFirst();
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                if (!strCountMap.containsKey(email)) {
                    strCountMap.put(email, c);
                    countStrMap.put(c, email);
                    wordNameMap.put(email, new ArrayList<>());
                    c++;
                }
                wordNameMap.get(email).add(name);
            }
        }
        UnionFind uf = new UnionFind(c);

        for (List<String> acc : accounts) {
            for (int i = 1; i < acc.size() - 1; i++) {
                String email1 = acc.get(i);
                String email2 = acc.get(i + 1);
                uf.union(strCountMap.get(email1), strCountMap.get(email2));
            }
        }

        Map<Integer, List<Integer>> parentMap = new HashMap<>();
        for (int i = 0; i < c; i++) {
            int root = uf.find(i);
            parentMap.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        List<List<String>> answer = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : parentMap.entrySet()) {
            String rootEmail = countStrMap.get(entry.getKey());
            Set<String> emails = new TreeSet<>();
            for (int index : entry.getValue()) {
                emails.add(countStrMap.get(index));
            }
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(wordNameMap.get(rootEmail).getFirst());
            mergedAccount.addAll(emails);
            answer.add(mergedAccount);
        }
        return answer;
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
