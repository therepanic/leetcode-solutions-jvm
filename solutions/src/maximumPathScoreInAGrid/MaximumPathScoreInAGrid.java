package maximumPathScoreInAGrid;

public class MaximumPathScoreInAGrid {

    public int maxPathScore(int[][] grid, Integer[][][] dp, int score, int costs, int m, int n, int k) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length) {
            return -1;
        }
        if (costs > k) {
            return -1;
        }
        if (m == 0 && n == 0) {
            return score;
        }
        if (dp[m][n][costs] != null) {
            if (dp[m][n][costs] == -1) {
                return -1;
            }
            return score + dp[m][n][costs];
        }
        int addScore = grid[m][n];
        int addCost = grid[m][n] > 0 ? 1 : 0;
        int a1 = -1;
        int a2 = -1;
        if (m - 1 >= 0 && m - 1 < grid.length) {
            a1 = maxPathScore(grid, dp, 0, costs + addCost, m - 1, n, k);
        }
        if (n - 1 >= 0 && n - 1 < grid[0].length) {
            a2 = maxPathScore(grid, dp, 0, costs + addCost, m, n - 1, k);
        }
        int best = Math.max(a1, a2);
        if (best == -1) {
            dp[m][n][costs] = -1;
            return -1;
        }
        dp[m][n][costs] = addScore + best;
        return score + dp[m][n][costs];
    }

    public int maxPathScore(int[][] grid, int k) {
        return maxPathScore(grid, new Integer[grid.length][grid[0].length][k + 1], 0, 0, grid.length - 1, grid[0].length - 1, k);
    }
}
