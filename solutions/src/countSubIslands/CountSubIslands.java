package countSubIslands;

public class CountSubIslands {
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        Boolean[][] checked = new Boolean[grid2.length][grid2[0].length];
        int count = 0;

        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1 && checked[i][j] == null) {
                    if (helper(i, j, grid1, grid2, checked)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static boolean helper(int n, int m, int[][] grid1, int[][] grid2, Boolean[][] checked) {
        if (n < 0 || m < 0 || n >= grid2.length || m >= grid2[n].length) {
            return true;
        }

        if (checked[n][m] != null) {
            return checked[n][m];
        }

        if (grid2[n][m] == 0 && grid1[n][m] == 0) {
            return true;
        } else if (grid2[n][m] == 1 && grid1[n][m] == 0) {
            checked[n][m] = false;
            return false;
        } else if (grid2[n][m] == 0 && grid1[n][m] == 1) {
            checked[n][m] = true;
            return true;
        }

        checked[n][m] = true;

        boolean left = helper(n - 1, m, grid1, grid2, checked);
        boolean right = helper(n + 1, m, grid1, grid2, checked);
        boolean up = helper(n, m - 1, grid1, grid2, checked);
        boolean down = helper(n, m + 1, grid1, grid2, checked);

        checked[n][m] = left && right && up && down;

        return checked[n][m];
    }
}
