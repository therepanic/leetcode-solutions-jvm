package findPolygonWithTheLargestPerimeter;

import java.util.Arrays;

public class FindPolygonWithTheLargestPerimeter {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        long max = -1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < prefixSum[i - 1]) {
                max = Math.max(max, prefixSum[i]);
            }
        }
        return max;
    }
}
