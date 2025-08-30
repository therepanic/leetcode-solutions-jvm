package findTheLeastFrequentDigit;

import java.util.HashMap;
import java.util.Map;

public class FindTheLeastFrequentDigit {
    public int getLeastFrequentDigit(int n) {
        String s = String.valueOf(n);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int val = Character.digit(c, 10);
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }
        int maxVal = Integer.MAX_VALUE;
        int maxC = Integer.MAX_VALUE;
        for (var entry : countMap.entrySet()) {
            if (entry.getValue() < maxC) {
                maxC = entry.getValue();
                maxVal = entry.getKey();
            } else if (entry.getValue() == maxC && entry.getKey() < maxVal) {
                maxVal = entry.getKey();
            }
        }
        return maxVal;
    }
}
