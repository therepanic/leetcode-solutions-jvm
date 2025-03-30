package minimumSumOfMountainTripletsI;

public class MinimumSumOfMountainTripletsI {
    public int minimumSum(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = nums[0];
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.min(left[i - 1], nums[i]);
        }
        int[] right = new int[nums.length];
        right[right.length - 1] = nums[nums.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }
        int sum = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > left[i] && nums[i] > right[i]) {
                sum = Math.min(sum, left[i] + right[i] + nums[i]);
            }
        }
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }
}
