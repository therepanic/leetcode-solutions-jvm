package deleteAndEarn;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        int maxNum = 0;

        for (int num : nums) {
            maxNum = Math.max(maxNum, num);

            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        int[] dp = new int[maxNum + 1];
        dp[1] = numCountMap.getOrDefault(1, 0);

        for (int i = 2; i <= maxNum; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * numCountMap.getOrDefault(i, 0));
        }

        return dp[maxNum];
    }
}
