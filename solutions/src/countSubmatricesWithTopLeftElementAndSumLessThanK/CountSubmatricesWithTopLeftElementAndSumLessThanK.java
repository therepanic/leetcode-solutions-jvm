package countSubmatricesWithTopLeftElementAndSumLessThanK;

public class CountSubmatricesWithTopLeftElementAndSumLessThanK {
    public static int countSubmatrices(int[][] grid, int k) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += grid[i][j - 1];
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] += grid[i - 1][j];
            }
        }

        int target = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] <= k) {
                    target++;
                }
            }
        }

        return target;
    }
}
