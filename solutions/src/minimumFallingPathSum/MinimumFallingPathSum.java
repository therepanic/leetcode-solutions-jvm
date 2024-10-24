package minimumFallingPathSum;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                int left = (j - 1 >= 0) ? matrix[i + 1][j - 1] : Integer.MAX_VALUE;
                int right = (j + 1 < matrix[0].length) ? matrix[i + 1][j + 1] : Integer.MAX_VALUE;
                int mid = matrix[i + 1][j];


                matrix[i][j] += Math.min(mid, Math.min(left, right));
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            answer = Math.min(answer, matrix[0][j]);
        }

        return answer;
    }
}
