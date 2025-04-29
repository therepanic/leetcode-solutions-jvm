package sortMatrixByDiagonals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortMatrixByDiagonals {
    public static int[][] sortMatrix(int[][] grid) {
        for (int i = grid[0].length - 1; i >= 0; i--) {
            int copyI = i;
            List<Integer> nums = new ArrayList<>();
            int it = 0;
            for (int j = 0; j < grid.length && copyI < grid[0].length; j++) {
                nums.add(grid[j][copyI]);
                it++;
                copyI++;
            }
            it = 0;
            Collections.sort(nums);
            if (i == 0) {
                Collections.reverse(nums);
            }
            copyI = i;
            for (int j = 0; j < grid.length && copyI < grid[0].length; j++) {
                grid[j][copyI] = nums.get(it);
                it++;
                copyI++;
            }
        }
        for (int i = 1; i < grid.length; i++) {
            List<Integer> nums = new ArrayList<>();
            int it = 0;
            int copyI = i;
            for (int j = 0; j < grid[0].length && copyI < grid.length; j++) {
                nums.add(grid[copyI][j]);
                it++;
                copyI++;
            }
            Collections.sort(nums);
            Collections.reverse(nums);
            it = 0;
            copyI = i;
            for (int j = 0; j < grid[0].length && copyI < grid.length; j++) {
                grid[copyI][j] = nums.get(it);
                it++;
                copyI++;
            }
        }
        return grid;
    }
}
