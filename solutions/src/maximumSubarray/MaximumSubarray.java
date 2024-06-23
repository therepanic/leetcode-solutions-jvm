package maximumSubarray;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxAt = 0;

        for (int num : nums) {
            maxAt = Math.max(num, maxAt + num);

            maxSoFar = Math.max(maxAt, maxSoFar);
        }

        return maxSoFar;
    }
}
