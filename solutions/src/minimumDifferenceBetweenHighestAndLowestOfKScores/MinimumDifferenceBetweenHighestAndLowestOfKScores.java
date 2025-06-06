package minimumDifferenceBetweenHighestAndLowestOfKScores;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            if (r - l + 1 > k) {
                l++;
            }
            if (r - l + 1 == k) {
                minDiff = Math.min(minDiff, nums[r] - nums[l]);
            }
        }
        return minDiff;
    }
}
