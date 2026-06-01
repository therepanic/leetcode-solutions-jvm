package countAlternatingSubarrays;

public class CountAlternatingSubarrays {
    public long countAlternatingSubarrays(int[] nums) {
        long ans = 1;
        long ret = 1;
        for (int i = 1; i < nums.length; i++) {
            ret = nums[i] == nums[i - 1] ? 1 : ret + 1;
            ans += ret;
        }
        return ans;
    }
}
