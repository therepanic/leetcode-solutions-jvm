package countSubarraysWithScoreLessThanK;

public class CountSubarraysWithScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        int l = 0;
        long c = 0;
        long sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }
            if (sum * (r - l + 1) < k) {
                c += r - l + 1;
            }
        }
        return c;
    }
}
