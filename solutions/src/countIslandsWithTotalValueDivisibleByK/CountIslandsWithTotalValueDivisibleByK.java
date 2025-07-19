package countIslandsWithTotalValueDivisibleByK;

public class CountIslandsWithTotalValueDivisibleByK {
    public int countIslands(int[][] grid, int k) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int c = 0;
        int[][] path = new int[][] {{1, 0}, {0, 1}, {-1 ,0}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    int sum = dfs(visited, i, j, grid, path);

                    if (sum % k == 0) {
                        c++;
                    }
                }
            }
        }
        return c;
    }

    public int dfs(boolean[][] visited, int n, int m, int[][] grid, int[][] path) {
        if (n < 0 || m < 0 || n >= grid.length || m >= grid[0].length || visited[n][m] || grid[n][m] == 0) return 0;
        visited[n][m] = true;
        int sum = grid[n][m];
        for (int[] p : path) {
            int x = n + p[0];
            int y = m + p[1];
            sum += dfs(visited, x, y, grid, path);
        }
        return sum;
    }
}
