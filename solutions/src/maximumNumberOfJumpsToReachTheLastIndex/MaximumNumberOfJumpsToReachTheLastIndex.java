package maximumNumberOfJumpsToReachTheLastIndex;

import java.util.Arrays;

public class MaximumNumberOfJumpsToReachTheLastIndex {

    static final int[] dp = new int[1001];

    public int maximumJumps(int[] nums, int target) {
        Arrays.fill(dp, -1);
        dp[0] = 0;
        return Math.max(helper(nums.length - 1, nums, target), -1);
    }

    public int helper(int i, int[] nums, int target) {
        if (i == 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < i; j++) {
            if (Math.abs(nums[i] - nums[j]) <= target) {
                ans = Math.max(ans, 1 + helper(j, nums, target));
            }
        }
        dp[i] = ans;
        return ans;
    }
}
