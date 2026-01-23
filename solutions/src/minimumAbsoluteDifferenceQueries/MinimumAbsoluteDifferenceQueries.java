package minimumAbsoluteDifferenceQueries;

public class MinimumAbsoluteDifferenceQueries {
    public int[] minDifference(int[] nums, int[][] queries) {
        int[][] pref = new int[nums.length][101];
        for (int i = 0; i < nums.length; i++) {
            pref[i][nums[i]]++;
            if (i != 0) {
                for (int j = 0; j < 101; j++) {
                    pref[i][j] += pref[i - 1][j];
                }
            }
        }
        int[] ans = new int[queries.length];
        for (int it = 0; it < queries.length; it++) {
            int[] query = queries[it];
            int[] pr = new int[101];
            for (int i = 0; i < 101; i++) {
                pr[i] += pref[query[1]][i];
                if (query[0] - 1 >= 0) {
                    pr[i] -= pref[query[0] - 1][i];
                }
            }
            int l = -1;
            int min = Integer.MAX_VALUE;
            for (int r = 0; r < 101; r++) {
                if (pr[r] > 0) {
                    if (l != -1) {
                        min = Math.min(min, Math.abs(l - r));
                    }
                    l = r;
                }
            }
            ans[it] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return ans;
    }
}
