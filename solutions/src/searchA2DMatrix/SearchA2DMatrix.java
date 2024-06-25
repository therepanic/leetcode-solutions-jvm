package searchA2DMatrix;

public class SearchA2DMatrix {
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int n = matrix[0].length - 1;
        int m = 0;

        while (n >= 0 && m < matrix.length) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }

        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int start = 0;
            int end = ints.length - 1;

            while (start <= end) {
                int middle = start + (end - start) / 2;

                if (ints[middle] > target) {
                    end--;
                } else if (ints[middle] < target) {
                    start++;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}
