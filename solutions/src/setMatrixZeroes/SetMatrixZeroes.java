package setMatrixZeroes;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] value = queue.poll();

            Arrays.fill(matrix[value[0]], 0);

            for (int i = 0; i < matrix.length; i++) {
                matrix[i][value[1]] = 0;
            }
        }
    }
}
