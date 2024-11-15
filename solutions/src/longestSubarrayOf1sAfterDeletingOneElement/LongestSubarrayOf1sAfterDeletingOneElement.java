package longestSubarrayOf1sAfterDeletingOneElement;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int longest = 0;

        int count = 0;
        int zeroCount = 0;

        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zeroCount++;
            }
            count++;

            while (zeroCount > 1) {
                if (nums[l] == 0) {
                    zeroCount--;
                }
                count--;
                l++;
            }

            longest = Math.max(count, longest);
        }

        return longest == 0 ? longest : longest - 1;
    }
}
