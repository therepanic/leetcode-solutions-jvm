package maximumSumOfAnHourglass;

public class MaximumSumOfAnHourglass {
    public int maxSum(int[][] grid) {
        int[][] prefixSum = new int[grid.length][grid[0].length];
        for (int i = 0; i < prefixSum.length; i++) {
            prefixSum[i][0] = grid[i][0];
            for (int j = 1; j < prefixSum[i].length; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + grid[i][j];
            }
        }
        int maxSum = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid.length - i < 3) {
                break;
            }
            for (int j = 2; j < grid[i].length; j++) {
                int curSum = prefixSum[i][j] + grid[i + 1][j - 1] + prefixSum[i + 2][j];
                if (j > 2) {
                    curSum -= prefixSum[i][j - 3];
                    curSum -= prefixSum[i + 2][j - 3];
                }
                maxSum = Math.max(curSum, maxSum);
            }
        }
        return maxSum;
    }
}
