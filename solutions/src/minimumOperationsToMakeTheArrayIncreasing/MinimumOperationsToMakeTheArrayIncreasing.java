package minimumOperationsToMakeTheArrayIncreasing;

public class MinimumOperationsToMakeTheArrayIncreasing {
    public int minOperations(int[] nums) {
        int c = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                int a = nums[i - 1] - nums[i] + 1;
                nums[i] += a;
                c += a;
            }
        }
        return c;
    }
}
