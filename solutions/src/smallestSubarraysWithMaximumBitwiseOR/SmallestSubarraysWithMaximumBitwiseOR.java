package smallestSubarraysWithMaximumBitwiseOR;

public class SmallestSubarraysWithMaximumBitwiseOR {
    public int[] smallestSubarrays(int[] nums) {
        int[] res = new int[30];
        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = 1;
            for (int j = 0; j < 30; j++) {
                if ((nums[i] & (1 << j)) > 0) {
                    res[j] = i;
                }
                ans[i] = Math.max(ans[i], res[j] - i + 1);
            }
        }
        return ans;
    }
}
