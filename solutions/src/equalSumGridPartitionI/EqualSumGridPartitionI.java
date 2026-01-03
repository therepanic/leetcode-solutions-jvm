package equalSumGridPartitionI;

import java.util.Arrays;
import java.util.List;

public class EqualSumGridPartitionI {
    public boolean canPartitionGrid(int[][] grid) {
        long[] upper = new long[grid.length];
        long[] down = new long[grid.length];
        long[] left = new long[grid[0].length];
        long[] right = new long[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            long sum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }
            upper[i] = sum;
            if (i > 0) {
                upper[i] += upper[i - 1];
            }
        }
        for (int i = grid.length - 1; i >= 0; i--) {
            long sum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }
            down[i] = sum;
            if (i < grid.length - 1) {
                down[i] += down[i + 1];
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            long sum = 0;
            for (int j = 0; j < grid.length; j++) {
                sum += grid[j][i];
            }
            left[i] = sum;
            if (i > 0) {
                left[i] += left[i - 1];
            }
        }
        for (int i = grid[0].length - 1; i >= 0; i--) {
            long sum = 0;
            for (int j = 0; j < grid.length; j++) {
                sum += grid[j][i];
            }
            right[i] = sum;
            if (i < grid[0].length - 1) {
                right[i] += right[i + 1];
            }
        }for (int i = 0; i < grid.length - 1; i++) {
            if (upper[i] == down[i + 1]) return true;
        }
        for (int i = 0; i < grid[0].length - 1; i++) {
            if (left[i] == right[i + 1]) return true;
        }
        return false;
    }
}
