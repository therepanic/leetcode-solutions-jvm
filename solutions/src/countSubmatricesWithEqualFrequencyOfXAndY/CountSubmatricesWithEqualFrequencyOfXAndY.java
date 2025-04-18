package countSubmatricesWithEqualFrequencyOfXAndY;

public class CountSubmatricesWithEqualFrequencyOfXAndY {
    public int numberOfSubmatrices(char[][] grid) {
        int c = 0;
        int[][] prefSumX = new int[grid.length + 1][grid[0].length + 1];
        int[][] prefSumY = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                prefSumY[i + 1][j + 1] = prefSumY[i + 1][j] + prefSumY[i][j + 1] - prefSumY[i][j] + (grid[i][j] == 'Y' ? 1 : 0);
                prefSumX[i + 1][j + 1] = prefSumX[i + 1][j] + prefSumX[i][j + 1] - prefSumX[i][j] + (grid[i][j] == 'X' ? 1 : 0);
                if (prefSumY[i + 1][j + 1] == prefSumX[i + 1][j + 1] && prefSumY[i + 1][j + 1] > 0) {
                    c++;
                }
            }
        }
        return c;
    }
}
