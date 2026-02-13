package findValidMatrixGivenRowAndColumnSums;

public class FindValidMatrixGivenRowAndColumnSums {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int i = 0;
        int j = 0;
        int[][] ans = new int[rowSum.length][colSum.length];
        while (i < rowSum.length && j < colSum.length) {
            int q = Math.min(rowSum[i], colSum[j]);
            ans[i][j] = q;
            rowSum[i] -= q;
            colSum[j] -= q;
            if (rowSum[i] == 0) {
                i++;
            }
            if (colSum[j] == 0) {
                j++;
            }
        }
        return ans;
    }
}
