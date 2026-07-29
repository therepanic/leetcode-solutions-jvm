package smallestRangeII;

import java.util.Arrays;

public class SmallestRangeII {
    public int smallestRangeII(int[] nums, int k) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        int diff = nums[nums.length - 1] - nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            int max = Math.max(nums[i] + k, nums[nums.length - 1] - k);
            diff = Math.min(diff, max - min);
        }
        return diff;
    }
}
