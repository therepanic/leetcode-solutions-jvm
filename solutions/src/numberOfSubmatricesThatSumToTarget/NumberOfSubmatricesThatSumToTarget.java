package numberOfSubmatricesThatSumToTarget;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int total = 0;

        for (int top = 0; top < matrix.length; top++) {
            int[] sum = new int[matrix[0].length];

            for (int bottom = top; bottom < matrix.length; bottom++) {
                for (int right = 0; right < matrix[bottom].length; right++) {
                    sum[right] += matrix[bottom][right];
                }

                Map<Integer, Integer> prefix = new HashMap<>(Map.of(0, 1));
                int curNum = 0;

                for (int cu : sum) {
                    curNum += cu;

                    total += prefix.getOrDefault(curNum - target, 0);

                    prefix.put(curNum, prefix.getOrDefault(curNum, 0) + 1);
                }
            }
        }

        return total;
    }
}
