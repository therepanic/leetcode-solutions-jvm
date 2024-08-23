package pathWithMaximumGold;

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int maximumGold = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    maximumGold = Math.max(maximumGold, helper(i, j, grid, 0));
                }
            }
        }

        return maximumGold;
    }

    public int helper(int n, int m, int[][] grid, int prefix) {
        if (n < 0 || m < 0 || n >= grid.length || m >= grid[n].length || grid[n][m] == 0) {
            return prefix;
        }

        int currentValue = grid[n][m] + prefix;

        grid[n][m] = 0;

        int maxGold = Math.max(Math.max(helper(n - 1, m, grid, currentValue), helper(n + 1, m, grid, currentValue)),
                Math.max(helper(n, m - 1, grid, currentValue), helper(n, m + 1, grid, currentValue)));

        grid[n][m] = currentValue - prefix;

        return maxGold;
    }
}
