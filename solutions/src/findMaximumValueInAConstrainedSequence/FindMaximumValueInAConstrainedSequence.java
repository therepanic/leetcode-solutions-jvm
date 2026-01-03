package findMaximumValueInAConstrainedSequence;

import java.util.Arrays;

public class FindMaximumValueInAConstrainedSequence {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        long[] v = new long[n];
        Arrays.fill(v, Long.MAX_VALUE);
        v[0] = 0;
        for (int[] r : restrictions) {
            int i = r[0];
            int maxVal = r[1];
            v[i] = Math.min(v[i], maxVal);
        }
        for (int i = 1; i < n; i++) {
            long step = diff[i - 1];
            v[i] = Math.min(v[i], v[i - 1] + step);
        }
        for (int i = n - 2; i >= 0; i--) {
            long step = diff[i];
            v[i] = Math.min(v[i], v[i + 1] + step);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] < 0) {
                v[i] = 0;
            }
            ans = Math.max(ans, v[i]);
        }
        return (int) ans;
    }
}
