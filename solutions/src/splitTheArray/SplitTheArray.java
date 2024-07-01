package splitTheArray;

import java.util.HashMap;
import java.util.Map;

public class SplitTheArray {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> keyToCountMap = new HashMap<>();

        for (int num : nums) {
            if (keyToCountMap.containsKey(num) && keyToCountMap.get(num) >= 2) {
                return false;
            }else if (keyToCountMap.containsKey(num)) {
                keyToCountMap.put(num, keyToCountMap.get(num) + 1);
            } else {
                keyToCountMap.put(num, 1);
            }
        }

        return true;
    }
}
