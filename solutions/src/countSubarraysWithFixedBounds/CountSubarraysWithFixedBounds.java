package countSubarraysWithFixedBounds;


public class CountSubarraysWithFixedBounds {
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;

        int l = -1;
        int r = -1;

        int invalid = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                invalid = i;
            }

            if (nums[i] == minK) {
                l = i;
            }

            if (nums[i] == maxK) {
                r = i;
            }

            int min = Math.min(l, r);

            if (min > invalid) {
                count += min - invalid;
            }
        }

        return count;
    }
}
