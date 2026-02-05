package maximumProductOfThreeElementsAfterOneReplacement;

public class MaximumProductOfThreeElementsAfterOneReplacement {
    public long maxProduct(int[] nums) {
        int max1 = -1;
        int max2 = -1;
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (v > max1) {
                max2 = max1;
                max1 = v;
            } else if (v > max2) {
                max2 = v;
            }
        }
        return (long) max1 * max2 * 100000L;
    }
}
