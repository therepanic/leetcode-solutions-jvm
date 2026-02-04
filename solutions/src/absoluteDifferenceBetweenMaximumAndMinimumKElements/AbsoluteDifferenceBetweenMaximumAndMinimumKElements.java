package absoluteDifferenceBetweenMaximumAndMinimumKElements;

import java.util.Arrays;

public class AbsoluteDifferenceBetweenMaximumAndMinimumKElements {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int maxSum = 0;
        int minSum = 0;
        for (int i = 0; i < k; i++) {
            minSum += nums[i];
        }
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            maxSum += nums[i];
        }
        return maxSum - minSum;
    }
}
