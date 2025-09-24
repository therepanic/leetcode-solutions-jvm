package rearrangeArrayToMaximizePrefixScore;

import java.util.Arrays;

public class RearrangeArrayToMaximizePrefixScore {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int score = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum <= 0) {
                return score;
            }
            score++;
        }
        return score;
    }
}
