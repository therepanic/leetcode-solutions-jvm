package numberOfLongestIncreasingSubsequence;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public static int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        int max = 0;
        for (int len : dp) {
            max = Math.max(max, len);
        }
        int answer = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                answer += count[i];;
            }
        }
        return answer;
    }
}
