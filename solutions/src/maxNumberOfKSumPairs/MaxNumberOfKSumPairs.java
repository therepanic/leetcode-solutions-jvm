package maxNumberOfKSumPairs;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;

        int operations = 0;
        while (l < r) {
            if (nums[l] + nums[r] == k) {
                operations++;
                l++;
                r--;
            } else if (nums[l] + nums[r] > k) {
                r--;
            } else {
                l++;
                continue;

            }
        }

        return operations;
    }
}
