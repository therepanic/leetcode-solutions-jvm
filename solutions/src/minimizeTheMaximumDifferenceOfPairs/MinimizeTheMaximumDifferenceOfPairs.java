package minimizeTheMaximumDifferenceOfPairs;

import java.util.Arrays;

public class MinimizeTheMaximumDifferenceOfPairs {

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int c = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] <= mid) {
                    i++;
                    c++;
                }
            }
            if (c < p) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

}
