package flipColumnsForMaximumNumberOfEqualRows;

import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberOfEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> numberCountMap = new HashMap<>();

        for (int[] arr : matrix) {
            StringBuilder orig = new StringBuilder();
            StringBuilder inverted = new StringBuilder();

            for (int num : arr) {
                orig.append(num);

                inverted.append(1 - num);
            }

            String origStr = orig.toString();
            String invertedStr = inverted.toString();

            numberCountMap.put(origStr, numberCountMap.getOrDefault(origStr, 0) + 1);
            numberCountMap.put(invertedStr, numberCountMap.getOrDefault(invertedStr, 0) + 1);
        }

        int max = 0;

        for (int val : numberCountMap.values()) {
            max = Math.max(val, max);
        }

        return max;
    }
}
