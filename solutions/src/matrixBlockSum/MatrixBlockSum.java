package matrixBlockSum;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] prefix = new int[mat.length + 1][mat[0].length + 1];

        for (int i = 1; i < prefix.length; i++) {
            for (int j = 1; j < prefix[0].length ; j++) {
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        int[][] result = new int[mat.length][mat[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                int l1 = Math.max(0, i - k);
                int r1 = Math.max(0, j - k);
                int l2 = Math.min(result.length - 1, i + k);
                int r2 = Math.min(result[0].length - 1, j + k);

                result[i][j] = prefix[l2 + 1][r2 + 1]
                        - prefix[l1][r2 + 1]
                        - prefix[l2 + 1][r1]
                        + prefix[l1][r1];
            }
        }
        return result;
    }
}
