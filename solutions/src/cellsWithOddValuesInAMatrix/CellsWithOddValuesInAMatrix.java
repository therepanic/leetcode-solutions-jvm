package cellsWithOddValuesInAMatrix;

public class CellsWithOddValuesInAMatrix {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int[] query : indices) {
            matrix[query[0]][query[1]] += 2;
            for (int i = query[0] + 1; i < matrix.length; i++) {
                matrix[i][query[1]]++;
            }
            for (int i = query[0] - 1; i >= 0; i--) {
                matrix[i][query[1]]++;
            }
            for (int i = query[1] + 1; i < matrix[0].length; i++) {
                matrix[query[0]][i]++;
            }
            for (int i = query[1] - 1; i >= 0; i--) {
                matrix[query[0]][i]--;
            }
        }
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 != 0) {
                    c++;
                }
            }
        }
        return c;
    }
}
