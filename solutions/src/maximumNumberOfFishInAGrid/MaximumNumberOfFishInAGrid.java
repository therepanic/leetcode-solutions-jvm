package maximumNumberOfFishInAGrid;

public class MaximumNumberOfFishInAGrid {
    public int findMaxFish(int[][] grid) {
        int maxFish = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxFish = Math.max(maxFish, helper(i, j, grid));
            }
        }

        return maxFish;
    }

    public int helper(int n, int m, int[][] grid) {
        if (n < 0 || m < 0 || n >= grid.length || m >= grid[n].length || grid[n][m] == 0) {
            return 0;
        }

        int currentFishes = grid[n][m];

        grid[n][m] = 0;

        currentFishes += helper(n - 1, m, grid) + helper(n + 1, m, grid) + helper(n, m - 1, grid) + helper(n, m + 1, grid);

        return currentFishes;
    }
}
