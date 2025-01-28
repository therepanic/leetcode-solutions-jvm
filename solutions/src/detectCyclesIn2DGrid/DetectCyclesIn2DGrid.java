package detectCyclesIn2DGrid;

public class DetectCyclesIn2DGrid {
    public boolean containsCycle(char[][] grid) {
        boolean[][] checked = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!checked[i][j]) {
                    boolean isCycle = bypass(i, j, -1, -1, grid, checked, grid[i][j]);
                    if (isCycle) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean bypass(int m, int n, int i, int j, char[][] grid, boolean[][] checked, char c) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] != c) {
            return false;
        }
        int[] up = new int[] {1, -1, 0, 0};
        int[] left = new int[] {0, 0, 1, -1};
        if (checked[m][n]) return true;
        checked[m][n] = true;
        for (int k = 0; k < 4; k++) {
            int nextM = m + up[k];
            int nextN = n + left[k];
            if (nextM == i && nextN == j) continue;
            if (bypass(nextM, nextN, m, n, grid, checked, c)) {
                return true;
            }
        }
        return false;
    }
}
