package maximumDifferenceBetweenEvenAndOddFrequencyI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumDifferenceBetweenEvenAndOddFrequencyI {

    public int maxDifference(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(charMap.values());
        int oddSmall = Integer.MAX_VALUE;
        int evenMax = Integer.MIN_VALUE;
        int oddMax = Integer.MIN_VALUE;
        int evenSmall = Integer.MAX_VALUE;
        for (int val : values) {
            if (val % 2 == 0) {
                evenMax = Math.max(evenMax, val);
                evenSmall = Math.min(evenSmall, val);
            } else {
                oddMax = Math.max(oddMax, val);
                oddSmall = Math.min(oddSmall, val);
            }
        }
        return Math.max(oddSmall - evenMax, oddMax - evenSmall);
    }

}
