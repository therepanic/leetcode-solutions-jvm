package maximumValidPairSum;

public class MaximumValidPairSum {
    public int maxValidPairSum(int[] nums, int k) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[right.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i]);
        }
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i + k < nums.length; i++) {
            ans = Math.max(ans, left[i] + right[i + k]);
        }
        return ans;
    }
}
