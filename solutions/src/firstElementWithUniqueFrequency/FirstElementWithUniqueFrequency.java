package firstElementWithUniqueFrequency;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstElementWithUniqueFrequency {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        for (int v : nums) {
            countMap.put(v, countMap.getOrDefault(v, 0) + 1);
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int v : countMap.values()) {
            freqMap.put(v, freqMap.getOrDefault(v, 0) + 1);
        }
        for (var entry : countMap.entrySet()) {
            if (freqMap.getOrDefault(entry.getValue(), -1) == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
