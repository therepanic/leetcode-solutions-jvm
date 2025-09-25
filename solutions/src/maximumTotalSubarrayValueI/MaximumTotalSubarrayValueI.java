package maximumTotalSubarrayValueI;

public class MaximumTotalSubarrayValueI {
    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        return ((long) max - min) * k;
    }
}
