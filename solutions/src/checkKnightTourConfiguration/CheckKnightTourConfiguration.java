package checkKnightTourConfiguration;

public class CheckKnightTourConfiguration {
    public boolean checkValidGrid(int[][] grid) {
        int[] dx = new int[] { 2, 2, -2, -2, 1, 1, -1, -1 };
        int[] dy = new int[] { 1, -1, 1, -1, 2, -2, 2, -2 };
        int max = grid.length * grid.length - 1;
        boolean[] check = new boolean[1];
        check(0, 0, grid, dx, dy, -1, max, check);
        return check[0];
    }

    private void check(int m, int n, int[][] grid, int[] dx, int[] dy, int cur, int max, boolean[] check) {
        if (check[0]) return;
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length) return;
        if (grid[m][n] != cur + 1) {
            return;
        } else if (grid[m][n] == max) {
            check[0] = true;
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            if (check[0]) return;
            int x = m + dx[i];
            int y = n + dy[i];
            check(x, y, grid, dx, dy, grid[m][n], max, check);
        }
    }
}
