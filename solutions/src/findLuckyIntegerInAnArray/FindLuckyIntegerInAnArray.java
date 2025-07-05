package findLuckyIntegerInAnArray;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInAnArray {

    public int findLucky(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int val : arr) {
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }
        int maxVal = -1;
        for (var entry : countMap.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                maxVal = Math.max(maxVal, entry.getKey());
            }
        }
        return maxVal;
    }

}
