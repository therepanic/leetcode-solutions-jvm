package maxAreaOfIsland;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] checked = new int[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, helper(i, j, grid, checked));
                }
            }
        }

        return maxArea;
    }

    public int helper(int m, int n, int[][] grid, int[][] checked) {
        if (m < 0 || n < 0 || grid.length <= m || grid[m].length <= n || grid[m][n] == 0 || checked[m][n] == -1) {
            return 0;
        }

        int maxArea = 0;
        maxArea += 1;

        checked[m][n] = -1;

        maxArea += helper(m + 1, n, grid, checked);
        maxArea += helper(m - 1, n, grid, checked);
        maxArea += helper(m, n + 1, grid, checked);
        maxArea += helper(m, n - 1, grid, checked);

        return maxArea;
    }
}
