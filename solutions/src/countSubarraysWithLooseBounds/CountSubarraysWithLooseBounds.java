package countSubarraysWithLooseBounds;

public class CountSubarraysWithLooseBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] < minK || nums[r] > maxK) {
                int a = r - l;
                ans += ((long) a * (a + 1)) / 2;
                l = r + 1;
            }
        }
        int a = nums.length - l;
        ans += ((long) a * (a + 1)) / 2;
        return ans;
    }
}
