package minimumXORPathInAGrid;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MinimumXORPathInAGrid {
    public int minCost(int[][] grid) {
        Set<Integer>[][] helper = new HashSet[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                helper[i][j] = new HashSet<>();
                if (i == 0 && j == 0) {
                    helper[i][j].add(grid[0][0]);
                } else {
                    if (i > 0) {
                        for (int val : helper[i - 1][j]) {
                            helper[i][j].add(val ^ grid[i][j]);
                        }
                    }
                    if (j > 0) {
                        for (int val : helper[i][j - 1]) {
                            helper[i][j].add(val ^ grid[i][j]);
                        }
                    }
                }
            }
        }
        return Collections.min(helper[grid.length - 1][grid[0].length - 1]);
    }
}
