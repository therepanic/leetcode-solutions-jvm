package minimumAbsoluteDifferenceInSlidingSubmatrix;

import java.util.*;

public class MinimumAbsoluteDifferenceInSlidingSubmatrix {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int[][] ans = new int[grid.length - k + 1][grid[0].length - k + 1];
        int[] values = new int[k * k];
        for (int i = 0; i <= grid.length - k; i++) {
            for (int j = 0; j <= grid[i].length - k; j++) {
                int size = 0;
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        values[size++] = grid[x][y];
                    }
                }
                Arrays.sort(values, 0, size);
                int min = Integer.MAX_VALUE;
                for (int it = 0; it < size - 1; it++) {
                    if (values[it] != values[it + 1]) {
                        min = Math.min(min, values[it + 1] - values[it]);
                    }
                }
                ans[i][j] = min == Integer.MAX_VALUE ? 0 : min;
            }
        }
        return ans;
    }
}
