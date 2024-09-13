package uniquePathsIII;

public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int maxSteps = 0;

        int[] robotIndex = new int[2];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    robotIndex[0] = i;
                    robotIndex[1] = j;
                }

                if (grid[i][j] == 0 || grid[i][j] == 2) {
                    maxSteps++;
                }
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] counter = new int[1];

        helper(robotIndex[0], robotIndex[1], grid, counter, visited, 0, maxSteps);

        return counter[0];
    }

    public void helper(int n, int m, int[][] grid, int[] counter, boolean[][] visited, int totalSteps, int maxSteps) {
        if (n < 0 || m < 0 || n >= grid.length || m >= grid[n].length || visited[n][m] || grid[n][m] == -1 || totalSteps > maxSteps) {
            return;
        }

        if (totalSteps == maxSteps && grid[n][m] != 2) {
            return;
        } else if (totalSteps == maxSteps && grid[n][m] == 2) {
            counter[0]++;
            return;
        }

        visited[n][m] = true;

        helper(n - 1, m, grid, counter, visited, totalSteps + 1, maxSteps);
        helper(n + 1, m, grid, counter, visited, totalSteps + 1, maxSteps);
        helper(n, m + 1, grid, counter, visited, totalSteps + 1, maxSteps);
        helper(n, m - 1, grid, counter, visited, totalSteps + 1, maxSteps);

        visited[n][m] = false;
    }
}
