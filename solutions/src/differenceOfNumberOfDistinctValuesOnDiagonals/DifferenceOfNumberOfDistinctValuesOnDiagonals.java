package differenceOfNumberOfDistinctValuesOnDiagonals;

import java.util.HashSet;
import java.util.Set;

public class DifferenceOfNumberOfDistinctValuesOnDiagonals {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int m = i - 1;
                int n = j - 1;
                Set<Integer> uniqueLeft = new HashSet<>();
                Set<Integer> uniqueRight = new HashSet<>();
                while (m >= 0 && n >= 0) {
                    uniqueLeft.add(grid[m][n]);
                    m--;
                    n--;
                }
                m = i + 1;
                n = j + 1;
                while (m < grid.length && n < grid[0].length) {
                    uniqueRight.add(grid[m][n]);
                    m++;
                    n++;
                }
                ans[i][j] = Math.abs(uniqueLeft.size() - uniqueRight.size());
            }
        }
        return ans;
    }
}
