package totalScoreOfDungeonRuns;

public class TotalScoreOfDungeonRuns {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long[] pref = new long[n + 1];
        pref[0] = 0;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + damage[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            long need = requirement[i - 1] + pref[i] - hp;
            int idx = lowerBound(pref, i, need);
            ans += i - idx;
        }
        return ans;
    }

    private int lowerBound(long[] arr, int right, long target) {
        int l = 0;
        int r = right;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
