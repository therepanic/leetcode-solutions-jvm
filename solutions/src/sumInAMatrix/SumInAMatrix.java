package sumInAMatrix;

import java.util.Arrays;

public class SumInAMatrix {
    public int matrixSum(int[][] nums) {
        int sum = 0;

        for (int[] row : nums) {
            Arrays.sort(row);
        }

        for (int i = 0; i < nums[0].length; i++) {
            int maxN = Integer.MIN_VALUE;

            for (int[] num : nums) {
                maxN = Math.max(maxN, num[i]);
            }

            sum += maxN;
        }
        return sum;
    }
}
