package longestIncreasingPathInAMatrix;

public class LongestIncreasingPathInAMatrix {
    public static int longestIncreasingPath(int[][] matrix) {
        int longestPath = 1;
        int[][] checked = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (checked[i][j] == 0) {
                    longestPath = Math.max(longestPath, check(true, i, j, matrix, checked,matrix[i][j], 1));
                } else {
                    longestPath = Math.max(longestPath, checked[i][j]);
                }
            }
        }

        return longestPath;
    }

    public static int check(boolean firstCall, int n, int m, int[][] matrix, int[][] checked, int prevValue, int longestPath) {
        if (n < 0 || m < 0 || n >= matrix.length || m >= matrix[n].length || checked[n][m] == -1) {
            return longestPath - 1;
        }

        if (!firstCall && prevValue >= matrix[n][m]) {
            return longestPath - 1;
        }

        if (checked[n][m] == 0) {
            checked[n][m] = -1;

            int leftPath = check(false, n - 1, m, matrix, checked, matrix[n][m], longestPath + 1);
            int rightPath = check(false,n + 1, m, matrix, checked, matrix[n][m], longestPath + 1);
            int downPath = check(false, n, m + 1, matrix, checked, matrix[n][m], longestPath + 1);
            int upPath = check(false, n, m - 1, matrix, checked, matrix[n][m], longestPath + 1);

            checked[n][m] = Math.max(Math.max(leftPath, rightPath), Math.max(downPath, upPath)) - longestPath;

            return Math.max(Math.max(leftPath, rightPath), Math.max(downPath, upPath));
        } else {
            return checked[n][m] + longestPath;
        }
    }

}
