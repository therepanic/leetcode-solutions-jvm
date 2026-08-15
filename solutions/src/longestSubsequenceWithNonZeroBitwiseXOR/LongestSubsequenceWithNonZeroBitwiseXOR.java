package longestSubsequenceWithNonZeroBitwiseXOR;

public class LongestSubsequenceWithNonZeroBitwiseXOR {
    public int longestSubsequence(int[] nums) {
        int x = 0;
        boolean nonZero = false;
        for (int v : nums) {
            x ^= v;
            nonZero |= v > 0;
        }
        if (!nonZero) {
            return 0;
        }
        return x == 0 ? nums.length - 1 : nums.length;
    }
}
