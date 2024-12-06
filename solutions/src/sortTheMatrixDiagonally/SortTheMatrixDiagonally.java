package sortTheMatrixDiagonally;

import java.util.PriorityQueue;

public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        for (int i = 0; i < mat[0].length; i++) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            int k = 0;
            for (int j = i; k < mat.length && j < mat[k].length; j++) {
                heap.add(mat[k][j]);
                k++;
            }
            k = 0;

            for (int j = i; k < mat.length && j < mat[k].length; j++) {
                mat[k][j] = heap.poll();
                k++;
            }
        }

        for (int i = 1; i < mat.length; i++) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            int k = i;

            for (int j = 0; k < mat.length && j < mat[k].length; j++) {
                heap.add(mat[k][j]);
                k++;
            }

            k = i;

            for (int j = 0; k < mat.length && j < mat[k].length; j++) {
                mat[k][j] = heap.poll();
                k++;
            }
        }

        return mat;
    }
}
