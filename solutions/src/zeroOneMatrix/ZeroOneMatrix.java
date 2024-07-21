package zeroOneMatrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ZeroOneMatrix {
    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new ArrayDeque<>();

        int[][] updatedMatrix = new int[mat.length][mat[0].length];

        for (int[] i : updatedMatrix) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    updatedMatrix[i][j] = 0;
                    queue.add(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pair = queue.peek();

            int i = pair[0];
            int j = pair[1];

            if (i > 0) {
                if (mat[i - 1][j] == 1) {
                    if (updatedMatrix[i - 1][j] > mat[i][j] + mat[i - 1][j]) {
                        updatedMatrix[i - 1][j] = Math.min(updatedMatrix[i - 1][j], mat[i][j] + mat[i - 1][j]);
                        mat[i - 1][j] = Math.min(updatedMatrix[i - 1][j], mat[i][j] + mat[i - 1][j]);
                        queue.add(new int[] {i - 1, j});
                    }
                }
            }

            if (j > 0) {
                if (mat[i][j - 1] == 1) {
                    if (updatedMatrix[i][j - 1] > mat[i][j] + mat[i][j - 1]) {
                        updatedMatrix[i][j - 1] = Math.min(updatedMatrix[i][j - 1], mat[i][j] + mat[i][j - 1]);
                        mat[i][j - 1] = Math.min(updatedMatrix[i][j - 1], mat[i][j] + mat[i][j - 1]);
                        queue.add(new int[] {i, j - 1});
                    }
                }
            }

            if (i < mat.length - 1) {
                if (mat[i + 1][j] == 1) {
                    if (updatedMatrix[i + 1][j] > mat[i][j] + mat[i + 1][j]) {
                        updatedMatrix[i + 1][j] = Math.min(updatedMatrix[i + 1][j], mat[i][j] + mat[i + 1][j]);
                        mat[i + 1][j] = Math.min(updatedMatrix[i + 1][j], mat[i][j] + mat[i + 1][j]);
                        queue.add(new int[] {i + 1, j});
                    }
                }

            }

            if (j < mat[i].length - 1) {
                if (mat[i][j + 1] == 1) {
                    if (updatedMatrix[i][j + 1] > mat[i][j] + mat[i][j + 1]) {
                        updatedMatrix[i][j + 1] = Math.min(updatedMatrix[i][j + 1], mat[i][j] + mat[i][j + 1]);
                        mat[i][j + 1] = Math.min(updatedMatrix[i][j + 1], mat[i][j] + mat[i][j + 1]);
                        queue.add(new int[] {i, j + 1});
                    }
                }
            }

            queue.poll();
        }

        return updatedMatrix;
    }
}
