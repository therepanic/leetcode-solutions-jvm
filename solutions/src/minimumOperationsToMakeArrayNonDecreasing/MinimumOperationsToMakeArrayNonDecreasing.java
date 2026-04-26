package minimumOperationsToMakeArrayNonDecreasing;

public class MinimumOperationsToMakeArrayNonDecreasing {
    public long minOperations(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += Math.max(0, nums[i] - nums[i + 1]);
        }
        return sum;
    }
}
