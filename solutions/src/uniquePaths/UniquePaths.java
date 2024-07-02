package uniquePaths;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        return helper(m, n, new int[m + 1][n + 1]);
    }

    public static int helper(int m, int n, int[][] paths) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        if (paths[m][n] == 0) {
            paths[m][n] = helper(m - 1, n, paths) + helper(m, n - 1, paths);
        }

        return paths[m][n];
    }


}
