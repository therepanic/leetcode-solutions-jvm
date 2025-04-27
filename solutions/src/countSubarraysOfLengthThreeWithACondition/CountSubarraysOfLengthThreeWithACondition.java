package countSubarraysOfLengthThreeWithACondition;

public class CountSubarraysOfLengthThreeWithACondition {
    public int countSubarrays(int[] nums) {
        int l = 0;
        int c = 0;
        for (int r = 0; r < nums.length; r++) {
            if (r - l + 1 == 4) {
                l++;
            }
            if (r - l + 1 == 3) {
                if ((nums[r] + nums[l]) * 2 == nums[r - 1]) {
                    c++;
                }
            }
        }
        return c;
    }
}
