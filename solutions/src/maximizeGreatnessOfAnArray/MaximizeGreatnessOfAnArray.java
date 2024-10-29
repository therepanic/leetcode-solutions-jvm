package maximizeGreatnessOfAnArray;

import java.util.Arrays;

public class MaximizeGreatnessOfAnArray {
    public static int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);

        int l = 0;
        int r = 1;

        int c = 0;
        while (l <= r && r < nums.length) {
            if (nums[l] < nums[r]) {
                c++;
                l++;
                r++;
            } else {
                r++;
            }
        }

        return c;
    }
}
