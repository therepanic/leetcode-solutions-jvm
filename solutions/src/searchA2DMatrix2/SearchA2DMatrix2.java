package searchA2DMatrix2;

public class SearchA2DMatrix2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length - 1;
        int m = 0;

        while (n >= 0 && m < matrix.length) {
            if (matrix[m][n] > target) {
                n--;
            } else if (matrix[m][n] < target) {
                m++;
            } else if (matrix[m][n] == target) {
                return true;
            }
        }

        return false;
    }
}
