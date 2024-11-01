package diagonalTraverse;

public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] answer = new int[m * n];
        int index = 0;
        boolean signal = true;

        for (int i = 0; i < n; i++) {
            int row = 0, col = i;
            int startIdx = index;

            while (row < m && col >= 0) {
                answer[index++] = mat[row][col];
                row++;
                col--;
            }

            if (signal) {
                swap(answer, startIdx, index - 1);
            }
            signal = !signal;
        }

        for (int i = 1; i < m; i++) {
            int row = i, col = n - 1;
            int startIdx = index;

            while (row < m && col >= 0) {
                answer[index++] = mat[row][col];
                row++;
                col--;
            }

            if (signal) {
                swap(answer, startIdx, index - 1);
            }

            signal = !signal;
        }

        return answer;
    }

    public static void swap(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
