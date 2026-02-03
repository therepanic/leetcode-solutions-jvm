package countCaesarCipherPairs;

import java.util.*;

public class CountCaesarCipherPairs {

    public static final class DSU {
        private final int[] p, sz;

        public DSU(int n) {
            p = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) { p[i] = i; sz[i] = 1; }
        }

        public int find(int x) {
            while (x != p[x]) {
                p[x] = p[p[x]];
                x = p[x];
            }
            return x;
        }

        public boolean union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return false;
            if (sz[a] < sz[b]) { int t = a; a = b; b = t; }
            p[b] = a;
            sz[a] += sz[b];
            return true;
        }

        public boolean same(int a, int b) { return find(a) == find(b); }
        public int size(int x) { return sz[find(x)]; }
    }

    public long countPairs(String[] words) {
        Map<String, Integer> groups = new HashMap<>();
        DSU dsu = new DSU(words.length);
        for (int i = 0; i < words.length; i++) {
            char[] w = words[i].toCharArray();
            for (int k = 0; k < 26; k++) {
                String key = new String(w);
                Integer idx = groups.putIfAbsent(key, i);
                if (idx != null) {
                    dsu.union(i, idx);
                }
                for (int j = 0; j < w.length; j++) {
                    w[j] = (w[j] == 'z') ? 'a' : (char) (w[j] + 1);
                }
            }
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int k = dsu.find(i);
            countMap.put(k, countMap.getOrDefault(k, 0) + 1);
        }
        long ans = 0;
        for (int val : countMap.values()) {
            ans += (long) val * (val - 1) / 2;
        }
        return ans;
    }
}
