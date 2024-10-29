package maximumNumberOfMovesInAGrid;

import java.util.Arrays;

public class MaximumNumberOfMovesInAGrid {
    public int maxMoves(int[][] grid) {
        int maxMoves = 0;
        int[][] moved = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            maxMoves = Math.max(maxMoves, bypass(i, 0, grid, moved));
        }

        return maxMoves;
    }

    public int bypass(int n, int m, int[][] grid, int[][] moved) {
        if (n < 0 || m < 0 || n >= grid.length || m >= grid[n].length) {
            return 0;
        }

        int right = 1;
        int digUp = 1;
        int digDown = 1;

        if (moved[n][m] == 0) {
            if (m + 1 < grid[n].length && grid[n][m] < grid[n][m + 1]) {
                right += bypass(n, m + 1, grid, moved);
            } else {
                right = 0;
            }

            if (n - 1 >= 0 && m + 1 < grid[n].length && grid[n][m] < grid[n - 1][m + 1]) {
                digUp += bypass(n - 1, m + 1, grid, moved);
            } else {
                digUp = 0;
            }

            if (n + 1 < grid.length && m + 1 < grid[n].length && grid[n][m] < grid[n + 1][m + 1]) {
                digDown += bypass(n + 1, m + 1, grid, moved);
            } else {
                digDown = 0;
            }

            int max = Math.max(Math.max(right, digUp), digDown);

            moved[n][m] = max;
        }

        return moved[n][m];
    }
}
