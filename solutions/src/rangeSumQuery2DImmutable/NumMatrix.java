package rangeSumQuery2DImmutable;

public class NumMatrix {

    private final int[][] matrix;

    public NumMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i > 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
                if (j > 0) {
                    matrix[i][j] += matrix[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    matrix[i][j] -= matrix[i - 1][j - 1];
                }
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = this.matrix[row2][col2];
        if (col1 -1 >= 0) {
            sum -= this.matrix[row2][col1 - 1];
        }
        if (row1 - 1 >= 0) {
            sum -= this.matrix[row1 - 1][col2];
            if (col1 - 1 >= 0) {
                sum += this.matrix[row1 - 1][col1 - 1];
            }
        }
        return sum;
    }

}
