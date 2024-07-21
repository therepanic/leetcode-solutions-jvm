package numberOfIslands;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int[][] checked = new int[grid.length][grid[0].length];
        int numOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && checked[i][j] == 0 && check(i, j, grid, checked)) {
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    private static boolean check(int n, int m, char[][] grid, int[][] checked) {
        if (n < 0 || m < 0 || n >= grid.length || m >= grid[n].length || checked[n][m] != 0 || grid[n][m] == '0') {
            return false;
        }

        if (grid[n][m] == '1') {
            checked[n][m] = 1;
        }

        boolean left = check(n, m - 1, grid, checked);
        boolean right = check(n, m + 1, grid, checked);
        boolean down = check(n - 1, m, grid, checked);
        boolean up = check(n + 1, m, grid, checked);;

        return grid[n][m] == '1' || left || right || down || up;
    }
}
