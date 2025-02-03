package longestStrictlyIncreasingOrStrictlyDecreasingSubarray;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int maxIncrease = 0;
        int minIncrease = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (l != r && nums[r] <= nums[r - 1]) {
                l++;
            }
            maxIncrease = Math.max(maxIncrease, r - l + 1);
        }
        l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (l != r && nums[r] >= nums[r - 1]) {
                l++;
            }
            minIncrease = Math.max(minIncrease, r - l + 1);
        }
        return Math.max(maxIncrease, minIncrease);
    }
}
