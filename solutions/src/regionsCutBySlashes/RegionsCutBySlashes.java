package regionsCutBySlashes;

public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int[][] matrix = new int[grid.length * 3][grid.length * 3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int r = 3 * i;
                int c = 3 * j;

                if (grid[i].charAt(j) == '/') {
                    matrix[r][c + 2] = 1;
                    matrix[r + 1][c + 1] = 1;
                    matrix[r + 2][c] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    matrix[r][c] = 1;
                    matrix[r + 1][c + 1] = 1;
                    matrix[r + 2][c + 2] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    bypass(i, j, matrix);
                    count++;
                }
            }
        }
        return count;
    }

    public void bypass(int m, int n, int[][] grid) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid.length || grid[m][n] == 1) {
            return;
        }
        grid[m][n] = 1;
        bypass(m + 1, n, grid);
        bypass(m - 1, n, grid);
        bypass(m, n + 1, grid);
        bypass(m, n - 1, grid);
    }
}
