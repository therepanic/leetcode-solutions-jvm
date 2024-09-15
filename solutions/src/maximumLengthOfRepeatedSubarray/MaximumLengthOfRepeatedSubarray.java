package maximumLengthOfRepeatedSubarray;

public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        return Math.max(findMaxLength(nums1, nums2), findMaxLength(nums2, nums1));
    }

    public int findMaxLength(int[] nums1, int[] nums2) {
        int maxLength = 0;

        for (int r = 0; r < nums1.length; r++) {
            int length = 0;
            for (int i = 0; i < nums1.length - r && i < nums2.length; i++) {
                if (nums1[i + r] == nums2[i]) {
                    length++;

                    maxLength = Math.max(maxLength, length);
                } else {
                    length = 0;
                }
            }
        }

        return maxLength;
    }
}
