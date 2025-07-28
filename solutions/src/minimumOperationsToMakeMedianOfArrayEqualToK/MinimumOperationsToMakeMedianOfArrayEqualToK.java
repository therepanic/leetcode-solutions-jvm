package minimumOperationsToMakeMedianOfArrayEqualToK;

import java.util.Arrays;

public class MinimumOperationsToMakeMedianOfArrayEqualToK {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        long operations = 0;
        Arrays.sort(nums);
        int middleIt = 0;
        if (nums.length % 2 != 0) {
            middleIt = nums.length / 2;
        } else {
            int a = nums[nums.length / 2];
            int b = nums[nums.length / 2 - 1];
            middleIt = a >= b ? nums.length / 2 : nums.length / 2 - 1;
        }
        if (nums[middleIt] > k) {
            for (int i = middleIt; i >= 0; i--) {
                if (nums[i] > k) {
                    operations += nums[i] - k;
                } else {
                    break;
                }
            }
        } else if (nums[middleIt] < k) {
            for (int i = middleIt; i < nums.length; i++) {
                if (nums[i] < k) {
                    operations += k - nums[i];
                } else {
                    break;
                }
            }
        }
        return operations;
    }
}
