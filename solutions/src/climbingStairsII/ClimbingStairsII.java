package climbingStairsII;

import java.util.Arrays;

public class ClimbingStairsII {
    public static int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i + j <= n) {
                    int costAtPos = costs[i + j - 1];
                    dp[i + j] = Math.min(dp[i + j], dp[i] + costAtPos + j * j);
                }
            }
        }
        return dp[n];
    }
}
