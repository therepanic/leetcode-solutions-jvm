package matrixSimilarityAfterCyclicShifts;

public class MatrixSimilarityAfterCyclicShifts {
    public boolean areSimilar(int[][] mat, int k) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (j % 2 == 0 && mat[i][(j + k) % mat[i].length] != mat[i][j]) {
                    return false;
                } else if (j % 2 != 0 && mat[i][(j - (k % mat[i].length) + mat[i].length) % mat[i].length] != mat[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
