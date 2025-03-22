package minimumOperationsToMakeAUniValueGrid;

import java.util.Arrays;

public class MinimumOperationsToMakeAUniValueGrid {
    public int minOperations(int[][] grid, int x) {
        int[] nums = new int[grid.length * grid[0].length];
        int it = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                nums[it] = grid[i][j];
                it++;
            }
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[0]) % x != 0) {
                return -1;
            }
        }
        int c = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            int diff = nums[nums.length - i - 1] - nums[i];
            if (diff % x != 0) {
                return -1;
            } else {
                c += diff / x;
            }
        }
        return c;
    }
}
