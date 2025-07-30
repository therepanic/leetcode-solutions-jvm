package longestSubarrayWithMaximumBitwiseAND;

public class LongestSubarrayWithMaximumBitwiseAND {
    public int longestSubarray(int[] nums) {
        int maxLength = 0;
        int curLength = 0;
        int maxVal = -1;
        for (int val : nums) {
            maxVal = Math.max(val, maxVal);
        }
        for (int val : nums) {
            if (val == maxVal) {
                curLength++;
                maxLength = Math.max(maxLength, curLength);
            } else {
                curLength = 0;
            }
        }
        return maxLength;
    }
}
