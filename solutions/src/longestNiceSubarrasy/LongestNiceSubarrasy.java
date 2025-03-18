package longestNiceSubarrasy;

public class LongestNiceSubarrasy {
    public static int longestNiceSubarray(int[] nums) {
        int l = 0;
        int maxSize = 0;
        int bitMask = 0;
        for (int r = 0; r < nums.length; r++) {
            int num = nums[r];
            while ((bitMask & num) != 0) {
                bitMask ^= nums[l];
                l++;
            }
            bitMask |= num;
            maxSize = Math.max(r - l + 1, maxSize);
        }
        return maxSize;
    }
}
