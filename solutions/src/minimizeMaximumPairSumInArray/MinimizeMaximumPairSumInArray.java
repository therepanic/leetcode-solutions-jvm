package minimizeMaximumPairSumInArray;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            min = Math.max(min, nums[i] + nums[nums.length - i - 1]);
        }
        return min;
    }
}
