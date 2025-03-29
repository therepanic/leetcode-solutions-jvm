package maximumValueOfAnOrderedTripletII;

public class MaximumValueOfAnOrderedTripletII {
    public static long maximumTripletValue(int[] nums) {
        int[] kNums = new int[nums.length];
        int minK = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            minK = Math.max(nums[i], minK);
            kNums[i] = minK;
        }
        long maxElement = nums[0];
        long maxDiff = nums[0] - nums[1];
        for (int i = 1; i < nums.length - 1; i++) {
            long currDiff = (maxElement - nums[i]) * kNums[i + 1];
            maxDiff = Math.max(maxDiff, currDiff);
            maxElement = Math.max(maxElement, nums[i]);
        }
        return maxDiff < 0 ? 0 : maxDiff;
    }
}
