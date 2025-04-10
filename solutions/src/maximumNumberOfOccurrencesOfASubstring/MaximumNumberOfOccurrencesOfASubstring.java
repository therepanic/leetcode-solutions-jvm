package maximumNumberOfOccurrencesOfASubstring;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfOccurrencesOfASubstring {
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] sChars = s.toCharArray();
        int freq = 0;
        Map<String, Integer> countMap = new HashMap<>();
        int l = 0;
        int[] chars = new int[26];
        for (int r = 0; r < sChars.length; r++) {
            if (r - l + 1 > minSize) {
                chars[sChars[l] - 'a']--;
                l++;
            }
            chars[sChars[r] - 'a']++;
            int unique = 0;
            for (int ch : chars) {
                if (ch > 0) {
                    unique++;
                }
            }
            if (r - l + 1 == minSize && unique <= maxLetters) {
                String str = s.substring(l, r + 1);
                int val = countMap.getOrDefault(str, 0) + 1;
                countMap.put(str, val);
                freq = Math.max(val, freq);
            }
        }
        return freq;
    }
}
