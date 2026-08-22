package maximumOR;

public class MaximumOR {
    public long maximumOr(int[] nums, int k) {
        long[] right = new long[nums.length];
        right[right.length - 1] = nums[nums.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = nums[i] | right[i + 1];
        }
        long left = 0;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            long a = (long) nums[i] << k;
            if (i < nums.length - 1) {
                a |= right[i + 1];
            }
            if (i > 0) {
                a |= left;
            }
            left |= nums[i];
            ans = Math.max(a, ans);
        }
        return ans;
    }
}
