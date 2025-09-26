package maximumProductOfFirstAndLastElementsOfASubsequence;

public class MaximumProductOfFirstAndLastElementsOfASubsequence {
    public long maximumProduct(int[] nums, int m) {
        int min = nums[0];
        int max = nums[0];
        long res = (long) nums[0] * nums[nums.length - 1];
        for (int i = m - 1; i < nums.length; i++) {
            min = Math.min(min, nums[i - m + 1]);
            max = Math.max(max, nums[i - m + 1]);
            res = Math.max(res, Math.max((long) min * nums[i], (long) max * nums[i]));
        }
        return res;
    }
}
