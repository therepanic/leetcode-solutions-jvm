package maximumAverageSubarray1;

public class MaximumAverageSubarray1 {
    public static double findMaxAverage(int[] nums, int k) {
        double maxAverage = Integer.MIN_VALUE;
        int numSum = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            numSum += nums[r];

            if (r + 1 >= k) {
                maxAverage = Math.max((double) numSum / k, maxAverage);

                numSum -= nums[l];

                l++;
            }
        }

        return maxAverage;
    }
}
