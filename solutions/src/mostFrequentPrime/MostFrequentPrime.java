package mostFrequentPrime;

import java.util.*;

public class MostFrequentPrime {
    public int mostFrequentPrime(int[][] mat) {
        int[][] dirs = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                for (int[] dir : dirs) {
                    go(i, j, dir[0], dir[1], mat, new int[1], valueMap);
                }
            }
        }
        int max = 1;
        for (var entry : valueMap.entrySet()) {
            max = Math.max(max, entry.getKey());
        }
        boolean[] sieve = sieve(max + 1);
        int freq = -1;
        int val = -1;
        for (var entry : valueMap.entrySet()) {
            if (sieve[entry.getKey()]) {
                if (freq < entry.getValue() || (entry.getValue() == freq && entry.getKey() > val)) {
                    freq = entry.getValue();
                    val = entry.getKey();
                }
            }
        }
        return val;
    }

    public void go(int x, int y, int u, int r, int[][] mat, int[] v, Map<Integer, Integer> valueMap) {
        if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length) {
            return;
        }
        v[0] *= 10;
        v[0] += mat[x][y];
        if (v[0] > 10) {
            valueMap.put(v[0], valueMap.getOrDefault(v[0], 0) + 1);
        }
        go(x + u, y + r, u, r, mat, v, valueMap);
    }

    public boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
