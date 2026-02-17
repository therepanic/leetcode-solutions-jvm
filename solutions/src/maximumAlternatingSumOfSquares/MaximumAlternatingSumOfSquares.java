package maximumAlternatingSumOfSquares;

import java.util.Arrays;

public class MaximumAlternatingSumOfSquares {
    public long maxAlternatingSum(int[] nums) {
        long[] sorted = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(sorted);
        long sum = 0;
        for (int i = 0; i < sorted.length / 2; i++) {
            sum += sorted[sorted.length - i - 1] - sorted[i];
        }
        sum += nums.length % 2 != 0 ? sorted[sorted.length / 2] : 0;
        return sum;
    }
}
