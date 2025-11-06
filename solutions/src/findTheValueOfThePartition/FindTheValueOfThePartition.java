package findTheValueOfThePartition;

import java.util.Arrays;

public class FindTheValueOfThePartition {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            min = Math.min(min, Math.abs(nums[i] - nums[i + 1]));
        }
        return min;
    }
}
