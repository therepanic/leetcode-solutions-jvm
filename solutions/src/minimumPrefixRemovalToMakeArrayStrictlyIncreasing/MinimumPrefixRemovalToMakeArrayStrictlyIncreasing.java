package minimumPrefixRemovalToMakeArrayStrictlyIncreasing;

public class MinimumPrefixRemovalToMakeArrayStrictlyIncreasing {
    public int minimumPrefixLength(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] <= nums[i - 1]) {
                break;
            }
            last = i - 1;
        }
        return last == 0 ? 0 : nums.length - (nums.length - last);
    }
}
