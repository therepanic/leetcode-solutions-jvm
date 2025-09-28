package splitArrayWithMinimumDifference;

public class SplitArrayWithMinimumDifference {
    public long splitArray(int[] nums) {
        long[] left = new long[nums.length];
        left[0] = nums[0];
        long[] right = new long[nums.length];
        right[right.length - 1] = nums[nums.length - 1];
        boolean[] bLeft = new boolean[nums.length];
        bLeft[0] = true;
        boolean[] bRight = new boolean[nums.length];
        bRight[bRight.length - 1] = true;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] + nums[i];
            if (nums[i] > nums[i - 1] && bLeft[i - 1]) {
                bLeft[i] = true;
            }
        }
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i];
            if (nums[i] > nums[i + 1] && bRight[i + 1]) {
                bRight[i] = true;
            }
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bLeft[i] && bRight[i + 1]) {
                ans = Math.min(ans, Math.abs(left[i] - right[i + 1]));
            }
        }
        return ans == Long.MAX_VALUE ? -1 : ans;
    }
}
