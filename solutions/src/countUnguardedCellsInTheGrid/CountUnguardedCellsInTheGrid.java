package countUnguardedCellsInTheGrid;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountUnguardedCellsInTheGrid {
    public void bypass(int n, int m, int[][] grid) {
        for (int i = n - 1; i >= 0; i--) {
            if (grid[i][m] == 1) {
                break;
            } else {
                grid[i][m] = 3;
            }
        }

        for (int i = n + 1; i < grid.length; i++) {
            if (grid[i][m] == 1) {
                break;
            } else {
                grid[i][m] = 3;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            if (grid[n][i] == 1) {
                break;
            } else {
                grid[n][i] = 3;
            }
        }

        for (int i = m + 1; i < grid[n].length; i++) {
            if (grid[n][i] == 1) {
                break;
            } else {
                grid[n][i] = 3;
            }
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        Queue<int[]> guardQueue = new ArrayDeque<>();

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
            guardQueue.add(new int[]{guard[0], guard[1]});
        }

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 1;
        }

        while (!guardQueue.isEmpty()) {
            int[] pair = guardQueue.poll();
            bypass(pair[0], pair[1], grid);
        }

        int count = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
