package minimumOperationsToMakeArrayValuesEqualToK;

import java.util.Arrays;

public class MinimumOperationsToMakeArrayValuesEqualToK {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int c = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                c++;
            }
        }
        if (nums[0] == k) return c;
        if (nums[0] < k) {
            return -1;
        }
        return c + 1;
    }
}
