package minimumDifferenceBetweenLargestAndSmallestValueInThreeMoves;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);

        int first = 0;
        int sec = 0;
        int thirst = 0;
        int fourth = 0;

        if (nums.length - 3 >= 0) {
            first = Math.abs(nums[nums.length - 3] - nums[1]);
        }

        if (nums.length - 4 >= 0) {
            sec = Math.abs(nums[nums.length - 4] - nums[0]);
        }

        if (2 < nums.length) {
            thirst = Math.abs(nums[nums.length - 2] - nums[2]);
        }

        if (3 < nums.length - 1) {
            fourth = Math.abs(nums[nums.length - 1] - nums[3]);
        }

        return Math.min(Math.min(first, sec), Math.min(thirst, fourth));
    }
}
