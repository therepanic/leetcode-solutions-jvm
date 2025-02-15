package cyclicallyRotatingAGrid;

public class CyclicallyRotatingAGrid {
    public static int[][] rotateGrid(int[][] grid, int k) {
        iter(grid, 0, 0, 0, k);
        return grid;
    }

    public static void iter(int[][] grid, int m, int n, int limit, int k) {
        if (grid.length - m - limit >= 4 && grid[0].length - n - limit >= 3) {
            iter(grid, m + 1, n + 1, limit + 1, k);
        }
        int top = m;
        int left = n;
        int bottom = grid.length - limit - 1;
        int right = grid[0].length - limit - 1;

        int rows = bottom - top + 1;
        int cols = right - left + 1;

        if (rows <= 1 || cols <= 1) return;

        int perimeter = 2 * (rows + cols) - 4;

        int[] border = new int[perimeter];
        int idx = 0;
        for (int j = left; j <= right; j++) {
            border[idx++] = grid[top][j];
        }
        for (int i = top + 1; i <= bottom - 1; i++) {
            border[idx++] = grid[i][right];
        }
        for (int j = right; j >= left; j--) {
            border[idx++] = grid[bottom][j];
        }
        for (int i = bottom - 1; i >= top + 1; i--) {
            border[idx++] = grid[i][left];
        }
        int shift = k % perimeter;
        int[] rotated = new int[perimeter];
        for (int i = 0; i < perimeter; i++) {
            rotated[i] = border[(i + shift) % perimeter];
        }
        idx = 0;
        for (int j = left; j <= right; j++) {
            grid[top][j] = rotated[idx++];
        }
        for (int i = top + 1; i <= bottom - 1; i++) {
            grid[i][right] = rotated[idx++];
        }
        for (int j = right; j >= left; j--) {
            grid[bottom][j] = rotated[idx++];
        }
        for (int i = bottom - 1; i >= top + 1; i--) {
            grid[i][left] = rotated[idx++];
        }
    }
}
