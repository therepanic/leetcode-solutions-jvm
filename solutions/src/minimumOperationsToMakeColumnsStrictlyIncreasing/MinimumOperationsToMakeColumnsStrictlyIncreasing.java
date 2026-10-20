package minimumOperationsToMakeColumnsStrictlyIncreasing;

public class MinimumOperationsToMakeColumnsStrictlyIncreasing {
    public int minimumOperations(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int a = grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                if (a >= grid[j][i]) {
                    ans += Math.abs(grid[j][i] - (a + 1));
                    grid[j][i] = a + 1;
                }
                a = grid[j][i];
            }
        }
        return ans;
    }
}
