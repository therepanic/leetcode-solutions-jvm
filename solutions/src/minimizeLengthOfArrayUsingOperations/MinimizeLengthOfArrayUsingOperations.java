package minimizeLengthOfArrayUsingOperations;

public class MinimizeLengthOfArrayUsingOperations {
    public int minimumArrayLength(int[] nums) {
        int v = nums[0];
        for (int i = 0; i < nums.length; i++) {
            v = Math.min(nums[i], v);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % v != 0) {
                return 1;
            }
            if (nums[i] == v) {
                count++;
            }
        }
        return (count + 1) / 2;
    }
}
