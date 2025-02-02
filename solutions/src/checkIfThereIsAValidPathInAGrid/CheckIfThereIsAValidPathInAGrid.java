package checkIfThereIsAValidPathInAGrid;

public class CheckIfThereIsAValidPathInAGrid {
    public boolean hasValidPath(int[][] grid) {
        return move(0, 0, grid, new boolean[grid.length][grid[0].length]);
    }

    public boolean move(int m, int n, int[][] grid, boolean[][] checked) {
        if (m == grid.length - 1 && n == grid[m].length - 1) return true;
        checked[m][n] = true;

        int[][] dirs = getDirections(grid[m][n]);
        for (int[] dir : dirs) {
            int i = m + dir[0];
            int j = n + dir[1];

            if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || checked[i][j]) continue;
            if (canConnect(dir, grid[i][j])) {
                if (move(i, j, grid, checked)) return true;
            }
        }
        return false;
    }

    private boolean canConnect(int[] direction, int neighborType) {
        int[] reverse = new int[] {-direction[0], -direction[1]};
        for (int[] nd : getDirections(neighborType)) {
            if (nd[0] == reverse[0] && nd[1] == reverse[1]) {
                return true;
            }
        }
        return false;
    }

    private int[][] getDirections(int type) {
        return switch (type) {
            case 1 -> new int[][] {{0, -1}, {0, 1}};
            case 2 -> new int[][] {{-1, 0}, {1, 0}};
            case 3 -> new int[][] {{0, -1}, {1, 0}};
            case 4 -> new int[][] {{0, 1}, {1, 0}};
            case 5 -> new int[][] {{0, -1}, {-1, 0}};
            case 6 -> new int[][] {{0, 1}, {-1, 0}};
            default -> new int[0][0];
        };
    }
}
