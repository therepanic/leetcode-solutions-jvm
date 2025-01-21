package gridGame;

import java.util.Arrays;

public class GridGame {
    public static void main(String[] args) {
        //System.out.println(gridGame(new int[][] {{2,5,4}, {1,5,1}}));
        //System.out.println(gridGame(new int[][] {{3,3,1}, {8,5,2}}));

        System.out.println(gridGame(new int[][] {{20,3,20,17,2,12,15,17,4,15},{20,10,13,14,15,5,2,3,14,3}}));
    }
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
