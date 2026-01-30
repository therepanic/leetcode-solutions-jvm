package minimumAverageOfSmallestAndLargestElements;

import java.util.Arrays;

public class MinimumAverageOfSmallestAndLargestElements {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            double a = ((double) nums[i] + nums[nums.length - i - 1]) / 2;
            min = Math.min(min, a);
        }
        return min;
    }
}
