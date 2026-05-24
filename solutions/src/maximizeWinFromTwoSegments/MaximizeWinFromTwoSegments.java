package maximizeWinFromTwoSegments;

public class MaximizeWinFromTwoSegments {
    public int maximizeWin(int[] prizePositions, int k) {
        int l = 0;
        int[] dp = new int[prizePositions.length + 1];
        int ans = 0;
        for (int r = 0; r < prizePositions.length; r++) {
            while (prizePositions[r] - prizePositions[l] > k) {
                l++;
            }
            dp[r + 1] = Math.max(dp[r], r - l + 1);
            ans = Math.max(ans, r - l + 1 + dp[l]);
        }
        return ans;
    }
}
