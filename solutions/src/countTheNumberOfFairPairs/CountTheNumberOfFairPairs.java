package countTheNumberOfFairPairs;

import java.util.Arrays;

public class CountTheNumberOfFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = lowBound(i + 1, nums.length - 1, lower - nums[i], nums);
            int high = lowBound(i + 1, nums.length - 1, upper - nums[i] + 1, nums);
            count += (long) high - low;
        }
        return count;
    }

    private int lowBound(int l, int r, int val, int[] nums) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
