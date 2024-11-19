package minimumLengthOfStringAfterOperations;

import java.util.HashMap;
import java.util.Map;

public class MinimumLengthOfStringAfterOperations {
    public int minimumLength(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        int sum = 0;

        for (int value : charCountMap.values()) {
            if (value <= 2) {
                sum += value;
                continue;
            }

            if (value % 2 != 0) {
                sum += 1;
            } else {
                sum += 2;
            }
        }

        return sum;
    }
}
