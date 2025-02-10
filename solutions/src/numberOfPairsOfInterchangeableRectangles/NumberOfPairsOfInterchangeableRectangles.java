package numberOfPairsOfInterchangeableRectangles;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsOfInterchangeableRectangles {
    public long interchangeableRectangles(int[][] rectangles) {
        long count = 0;
        Map<Double, Integer> valCountMap = new HashMap<>();
        for (int[] rect : rectangles) {
            double val = (double) rect[0] / rect[1];
            int key = valCountMap.getOrDefault(val, 0);
            count += key;
            valCountMap.put(val, key + 1);
        }
        return count;
    }
}
