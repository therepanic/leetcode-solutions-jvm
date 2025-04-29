package maximumSumWithAtMostKElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumSumWithAtMostKElements {
    public static long maxSum(int[][] grid, int[] limits, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
            int c = 0;
            for (int j = grid[i].length - 1; j >= 0 && c < limits[i]; j--) {
                nums.add(grid[i][j]);
                c++;
            }
        }
        Collections.sort(nums);
        long sum = 0;
        for (int i = nums.size() - 1; i >= 0 && k != 0; i--) {
            sum += nums.get(i);
            k--;
        }
        return sum;
    }
}
