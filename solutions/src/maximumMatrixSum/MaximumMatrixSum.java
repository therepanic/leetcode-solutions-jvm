package maximumMatrixSum;

public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        int negativeCount = 0;
        long matrixSum = 0;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) {
                    negativeCount++;
                }

                min = Math.min(min, Math.abs(matrix[i][j]));
                matrixSum += Math.abs(matrix[i][j]);
            }
        }

        int negativeCountBalancer = negativeCount % 2;

        if (negativeCountBalancer == 0) {
            return matrixSum;
        } else {
            return matrixSum - 2L * min;

        }
    }
}
