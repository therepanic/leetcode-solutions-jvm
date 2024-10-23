package minimumPathSum;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] know = new int[grid.length][grid[0].length];

        return bypass(grid.length - 1, grid[0].length - 1, grid, know);
    }

    public int bypass(int n, int m, int[][] grid, int[][] know) {
        if (n == 0 && m == 0) return grid[n][m];

        int left = Integer.MAX_VALUE;

        if (n - 1 >= 0 && know[n - 1][m] == 0) {
            know[n - 1][m] = bypass(n - 1, m, grid, know);

            left = know[n - 1][m];
        } else if (n - 1 >= 0) {
            left = know[n - 1][m];
        }

        int up = Integer.MAX_VALUE;

        if (m - 1 >= 0 && know[n][m - 1] == 0) {
            know[n][m - 1] = bypass(n, m - 1, grid, know);

            up = know[n][m - 1];
        } else if (m - 1 >= 0) {
            up = know[n][m - 1];
        }

        know[n][m] = (Math.min(left, up) + grid[n][m]) % Integer.MAX_VALUE;

        return know[n][m];
    }
}
