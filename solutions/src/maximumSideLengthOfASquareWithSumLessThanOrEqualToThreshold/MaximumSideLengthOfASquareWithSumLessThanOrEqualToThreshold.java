package maximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold;

public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int[][] prefSum = new int[mat.length + 1][mat[0].length + 1];
        for (int i = 1; i <= mat.length; i++) {
            for (int j = 1; j <= mat[0].length; j++) {
                prefSum[i][j] = mat[i - 1][j - 1] + prefSum[i - 1][j] + prefSum[i][j - 1] - prefSum[i - 1][j - 1];
            }
        }
        int l = 0;
        int r = Math.min(mat.length, mat[0].length);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(mat, prefSum, mid, mid, threshold)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public boolean check(int[][] mat, int[][] prefSum, int m, int n, int threshold) {
        for (int i = 0; i <= mat.length - m; i++) {
            for (int j = 0; j <= mat[0].length - n; j++) {
                int sum = prefSum[m + i][n + j] - prefSum[m + i][j] - prefSum[i][j + n] + prefSum[i][j];
                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
