package rangeProductQueriesOfPowers;

import java.util.ArrayList;
import java.util.List;

public class RangeProductQueriesOfPowers {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(i);
            }
        }
        long[] pref = new long[powers.size()];
        pref[0] = powers.getFirst();
        for (int i = 1; i < powers.size(); i++) {
            pref[i] = (pref[i - 1] + powers.get(i));
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long sum = pref[r] - (l == 0 ? 0 : pref[l - 1]);
            ans[i] = (int) (modPow(sum, 1_000_000_007));
        }
        return ans;
    }

    static long modPow(long e, int mod) {
        long res = 1;
        long a = 2;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            e >>= 1;
        }
        return res;
    }
}
