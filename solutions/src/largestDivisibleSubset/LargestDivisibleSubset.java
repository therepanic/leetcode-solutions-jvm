package largestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int maxIndex = 0;
        int maxVal = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxVal) {
                maxVal = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i--) {
            if (nums[maxIndex] % nums[i] == 0 && dp[i] == maxVal) {
                answer.add(nums[i]);
                maxIndex = i;
                maxVal--;
            }
        }
        Collections.reverse(answer);
        return answer;
    }
}
