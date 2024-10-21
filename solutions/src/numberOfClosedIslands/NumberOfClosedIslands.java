package numberOfClosedIslands;

import java.util.*;

public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                queue.add(new int[] {i, 0});
            }

            if (grid[i][grid[0].length - 1] == 0) {
                queue.add(new int[] {i, grid[0].length - 1});
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 0) {
                queue.add(new int[] {0, i});
            }

            if (grid[grid.length - 1][i] == 0) {
                queue.add(new int[] {grid.length - 1, i});
            }
        }

        while (!queue.isEmpty()) {
            int[] val = queue.poll();

            if (grid[val[0]][val[1]] != 0) {
                continue;
            }

            grid[val[0]][val[1]] = 1;


            if (val[0] - 1 >= 0) {
                queue.add(new int[] {val[0] - 1, val[1]});
            }

            if (val[1] - 1 >= 0) {
                queue.add(new int[] {val[0], val[1] - 1});
            }

            if (val[0] + 1 < grid.length) {
                queue.add(new int[] {val[0] + 1, val[1]});
            }

            if (val[1] + 1 < grid[0].length) {
                queue.add(new int[] {val[0], val[1] + 1});
            }
        }
        int c = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    bypass(i, j, grid);
                    c++;
                }
            }
        }

        return c;
    }

    public void bypass(int n, int m, int[][] grid) {
        if (n < 0 || m < 0 || n >= grid.length || m >= grid[n].length || grid[n][m] == 1) {
            return;
        }

        grid[n][m] = 1;

        bypass(n - 1, m, grid); bypass(n + 1, m, grid); bypass(n, m - 1, grid); bypass(n, m + 1, grid);
    }
}
