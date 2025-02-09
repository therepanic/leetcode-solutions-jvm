package kdifPairsInAnArray;

import java.util.HashMap;
import java.util.Map;

public class KdifPairsInAnArray {
    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> valMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int d = nums[i] + k;
            if (!valMap.containsKey(d)) {
                if (k == 0) {
                    valMap.put(d, 2);
                } else {
                    valMap.put(d, 1);
                }
            }
        }
        int allPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            int d = nums[i];
            if (valMap.containsKey(d)) {
                valMap.put(d, valMap.get(d) - 1);
                if (valMap.get(d) == 0) {
                    allPairs++;
                    valMap.remove(d);
                }
            }
        }
        return allPairs;
    }
}
