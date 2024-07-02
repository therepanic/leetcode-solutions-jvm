package uniquePaths2;

public class UniquePaths2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[obstacleGrid.length - 1].length - 1] == 1) {
            return 0;
        } else if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        return helper(obstacleGrid.length - 1, obstacleGrid[0].length - 1, new int[obstacleGrid.length][obstacleGrid[0].length], obstacleGrid);
    }

    public static int helper(int m, int n, int[][] paths, int[][] obstacleGrid) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (m == 0 && n == 0) {
            return 1;
        }

        if (obstacleGrid[m][n] == 1) {
            return 0;
        }

        int pathValue = paths[m][n];

        if (pathValue == 0) {
            paths[m][n] = helper(m - 1, n, paths, obstacleGrid) + helper(m, n - 1, paths, obstacleGrid);
        }

        return paths[m][n];
    }
}
