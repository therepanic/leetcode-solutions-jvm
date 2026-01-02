package largestElementInAnArrayAfterMergeOperations;

public class LargestElementInAnArrayAfterMergeOperations {
    public long maxArrayValue(int[] nums) {
        long sum = nums[nums.length - 1];
        long max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= sum) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
