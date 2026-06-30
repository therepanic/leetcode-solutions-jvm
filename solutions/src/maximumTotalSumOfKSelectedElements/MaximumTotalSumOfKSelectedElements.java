package maximumTotalSumOfKSelectedElements;

import java.util.Arrays;

public class MaximumTotalSumOfKSelectedElements {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long sum = 0;
        for (int i = nums.length - 1; i >= 0 && k > 0; i--, k--) {
            if ((long) nums[i] * mul <= nums[i]) {
                sum += nums[i];
            } else {
                sum += (long) nums[i] * mul;
            }
            mul--;
        }
        return sum;
    }
}
