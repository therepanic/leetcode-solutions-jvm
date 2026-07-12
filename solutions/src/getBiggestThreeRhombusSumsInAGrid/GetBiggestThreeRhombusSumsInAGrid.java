package getBiggestThreeRhombusSumsInAGrid;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GetBiggestThreeRhombusSumsInAGrid {
    public int[] getBiggestThree(int[][] grid) {
        PriorityQueue<Integer> minThree = new PriorityQueue<>();
        Set<Integer> been = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!been.contains(grid[i][j])) {
                    been.add(grid[i][j]);
                    minThree.add(grid[i][j]);
                    if (minThree.size() > 3) {
                        minThree.poll();
                    }
                }
                for (int c = 1; c <= 100; c++) {
                    int a = helper(i, j, grid, c, c, 1);
                    if (a != -1) {
                        if (been.contains(a)) {
                            continue;
                        }
                        minThree.add(a);
                        been.add(a);
                        if (minThree.size() > 3) {
                            minThree.poll();
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        int[] ans = new int[minThree.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = minThree.poll();
        }
        return ans;
    }

    public int helper(int m, int n, int[][] grid, int height, int curHeight, int dir) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length) {
            return -1;
        }
        if (curHeight == 0) {
            curHeight = height;
            dir++;
            if (dir == 5) {
                return 0;
            }
        }
        int a;
        if (dir == 1) {
            a = helper(m + 1, n - 1, grid, height, curHeight - 1, dir);
        } else if (dir == 2) {
            a = helper(m + 1, n + 1, grid, height, curHeight - 1, dir);
        } else if (dir == 3) {
            a = helper(m - 1, n + 1, grid, height, curHeight - 1, dir);
        } else {
            a = helper(m - 1, n - 1, grid, height, curHeight - 1, dir);
        }
        if (a == -1) {
            return -1;
        }
        return grid[m][n] + a;
    }
}
