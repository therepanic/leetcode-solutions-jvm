package minimumMovesToEqualArrayElementsII;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int c = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            c += nums[nums.length - i - 1] - nums[i];
        }
        return c;
    }
}
