package largestSubmatrixWithRearrangements;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {
    public int largestSubmatrix(int[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }
            int[] a = heights.clone();
            Arrays.sort(a);;
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, a[j] * (matrix[0].length - j));
            }
        }
        return ans;
    }
}
