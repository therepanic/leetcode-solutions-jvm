package maximalSquare;

import java.util.Arrays;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        helper(0, 0, dp, matrix);

        int maxSquare = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                int product = dp[i][j] * dp[i][j];

                maxSquare = Math.max(maxSquare, product);
            }
        }

        return maxSquare;
    }

    public int helper(int n, int m, int[][] dp, char[][] matrix) {
        if (n >= dp.length || m >= dp[n].length) {
            return 0;
        }

        if (dp[n][m] == -1) {
            dp[n][m] = 0;

            int right = helper(n, m + 1, dp, matrix);
            int down = helper(n + 1, m, dp, matrix);
            int dig = helper(n + 1, m + 1, dp, matrix);

            if (matrix[n][m] == '1') {
                dp[n][m] = Math.min(Math.min(right, down), dig) + 1;
            }
        }

        return dp[n][m];
    }
}
