package coloringABorder;

public class ColoringABorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] checked = new boolean[grid.length][grid[0].length];
        bypass(grid, row, col, grid[row][col], color, checked);
        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked[i].length; j++) {
                if (checked[i][j] && i > 0 && j > 0 && i < checked.length - 1 && j < checked[i].length - 1 && checked[i - 1][j]
                        && checked[i + 1][j] && checked[i][j - 1] && checked[i][j + 1]) {
                    continue;
                } else if (checked[i][j]){
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private void bypass(int[][] grid, int m, int n, int color, int neededColor, boolean[][] checked) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] != color || checked[m][n]) return;
        checked[m][n] = true;
        bypass(grid, m + 1, n, color, neededColor, checked);
        bypass(grid, m - 1, n, color, neededColor, checked);
        bypass(grid, m, n + 1, color, neededColor, checked);
        bypass(grid, m, n - 1, color, neededColor, checked);
    }
}
