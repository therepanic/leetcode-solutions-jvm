package sumOfBeautyOfAllSubstrings;

import java.util.HashMap;
import java.util.Map;

public class SumOfBeautyOfAllSubstrings {
    public static int beautySum(String s) {
        int sum = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (charFreqMap.containsKey(c)) {
                    charFreqMap.put(c, charFreqMap.get(c) + 1);
                } else {
                    charFreqMap.put(c, 1);
                }

                int maxF = Integer.MIN_VALUE;
                int minF = Integer.MAX_VALUE;

                for (int freq : charFreqMap.values()) {
                    maxF = Math.max(maxF, freq);
                    minF = Math.min(minF, freq);
                }

                sum += maxF - minF;
            }
            charFreqMap = new HashMap<>();
        }

        return sum;
    }
}
