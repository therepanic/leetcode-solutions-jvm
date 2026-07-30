package maximizeSumOfArrayAfterKNegations;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; k > 0 && i < nums.length && nums[i] < 0; i++, k--) {
            nums[i] = -nums[i];
        }
        int res = 0, min = Integer.MAX_VALUE;
        for (int a : nums) {
            res += a;
            min = Math.min(min, a);
        }
        return res - (k % 2) * min * 2;
    }
}
