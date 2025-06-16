package maximumDifferenceBetweenIncreasingElements;

public class MaximumDifferenceBetweenIncreasingElements {

    public int maximumDifference(int[] nums) {
        int[] max = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                max[i] = nums[i];
            } else {
                max[i] = Math.max(max[i + 1], nums[i]);
            }
        }
        int maxDiff = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (max[i + 1] <= nums[i]) continue;
            maxDiff = Math.max(maxDiff, max[i + 1] - nums[i]);
        }
        return maxDiff;
    }

}
