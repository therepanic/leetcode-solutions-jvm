package maximumMatrixSum;

public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        int negCount = 0;
        int minNum = Integer.MAX_VALUE;
        boolean isActive = true;

        for (int[] i : matrix) {
            for (int j : i) {
                minNum = Math.min(minNum, Math.abs(j));

                if (j < 0) {
                    negCount++;
                }
            }
        }

        long sum = 0;

        if (negCount % 2 == 0) {
            for (int[] i : matrix) {
                for (int j : i) {
                    sum += Math.abs(j);
                }
            }
        } else {
            for (int[] i : matrix) {
                for (int j : i) {
                    if (Math.abs(j) == minNum && isActive) {
                        sum -= Math.abs(j);
                        isActive = false;
                    } else {
                        sum += Math.abs(j);
                    }
                }
            }
        }

        return sum;
    }
}
