package firstCompletelyPaintedRowOrColumn;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowOrColumn {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> valuePosMap = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                valuePosMap.put(mat[i][j], new int[] {i, j});
            }
        }

        int[] col = new int[mat.length];
        int[] row = new int[mat[0].length];

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int[] pos = valuePosMap.get(val);

            col[pos[0]]++;

            if (col[pos[0]] >= mat[0].length) {
                return i;
            }

            row[pos[1]]++;

            if (row[pos[1]] >= mat.length) {
                return i;
            }
        }

        return -1;
    }
}
