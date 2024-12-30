package toeplitzMatrix;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            int r = i + 1;
            int d = 1;

            while (r < matrix[0].length && d < matrix.length) {
                if (matrix[d][r] != matrix[0][i]) {
                    return false;
                }
                r++;
                d++;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            int r = 1;
            int d = i + 1;

            while (r < matrix[0].length && d < matrix.length) {
                if (matrix[d][r] != matrix[i][0]) {
                    return false;
                }
                r++;
                d++;
            }
        }

        return true;
    }
}
