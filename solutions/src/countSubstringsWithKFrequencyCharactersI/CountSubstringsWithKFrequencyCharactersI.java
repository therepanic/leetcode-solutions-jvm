package countSubstringsWithKFrequencyCharactersI;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringsWithKFrequencyCharactersI {
    public int numberOfSubstrings(String s, int k) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        char[] sChars = s.toCharArray();

        int count = 0;

        int l = 0;

        for (int r = 0; r < sChars.length; r++) {
            int newVal = charCountMap.getOrDefault(sChars[r], 0) + 1;
            charCountMap.put(sChars[r], newVal);

            while (charCountMap.get(sChars[r]) >= k) {
                charCountMap.put(sChars[l], charCountMap.get(sChars[l]) - 1);

                count += s.length() - r;

                l++;

            }
        }

        return count;
    }
}
