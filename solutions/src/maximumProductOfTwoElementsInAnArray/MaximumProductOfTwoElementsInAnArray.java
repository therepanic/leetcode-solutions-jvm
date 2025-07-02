package maximumProductOfTwoElementsInAnArray;

public class MaximumProductOfTwoElementsInAnArray {

    public int maxProduct(int[] nums) {
        int max = 0;
        int maxTwo = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                maxTwo = max;
                max = Math.max(nums[i], max);
            } else if (maxTwo < nums[i]) {
                maxTwo = Math.max(nums[i], maxTwo);
            }
        }
        return (max - 1) * (maxTwo - 1);
    }

}
