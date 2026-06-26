package differenceBetweenOnesAndZerosInRowAndColumn;

public class DifferenceBetweenOnesAndZerosInRowAndColumn {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] col = new int[grid.length];
        int[] row = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int ones = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ones++;
                }
            }
            col[i] = ones;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int ones = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    ones++;
                }
            }
            row[i] = ones;
        }
        int[][] ans = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans[i][j] = col[i] + row[j] - (grid.length - col[i]) - (grid[0].length - row[j]);
            }
        }
        return ans;
    }
}
