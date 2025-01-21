package gridGame;

import java.util.Arrays;

public class GridGame {
    public static long gridGame(int[][] grid) {
        int n = grid[0].length;

        long[] top = new long[n + 1];
        long[] bottom = new long[n + 1];

        for (int i = 0; i < n; i++) {
            top[i + 1] = top[i] + grid[0][i];
            bottom[i + 1] = bottom[i] + grid[1][i];
        }

        long result = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long temp = Math.max(top[n] - top[i + 1], bottom[i]);
            result = Math.min(temp, result);
        }

        return result;
    }
}
