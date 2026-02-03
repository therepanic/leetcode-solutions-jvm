package maximumScoreOfASplit;

public class MaximumScoreOfASplit {
    public long maximumScore(int[] nums) {
        long[] pref = new long[nums.length];
        pref[0] = nums[0];
        for (int i = 1; i < pref.length; i++) {
            pref[i] += pref[i - 1] + nums[i];
        }
        int[] suffix = new int[nums.length];
        int min = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(nums[i], min);
            suffix[i] = min;
        }
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, pref[i] - suffix[i + 1]);
        }
        return max;
    }
}
