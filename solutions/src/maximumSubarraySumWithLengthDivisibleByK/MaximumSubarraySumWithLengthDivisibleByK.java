package maximumSubarraySumWithLengthDivisibleByK;

public class MaximumSubarraySumWithLengthDivisibleByK {
    public long maxSubarraySum(int[] nums, int k) {
        long[] pref = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }
        long ans = Long.MIN_VALUE;
        for (int p = 0; p < k; p++) {
            long sum = Integer.MIN_VALUE;
            for (int j = p; j + k <= nums.length; j += k) {
                long s = pref[j + k] - pref[j];
                sum = Math.max(s, sum + s);
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
