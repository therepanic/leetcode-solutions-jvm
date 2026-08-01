package combinationSumIV;

import java.util.Arrays;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, dp, target);
    }

    public int helper(int[] nums, int[] dp, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                ans += helper(nums, dp, target - nums[i]);
            }
        }
        return dp[target] = ans;
    }
}
