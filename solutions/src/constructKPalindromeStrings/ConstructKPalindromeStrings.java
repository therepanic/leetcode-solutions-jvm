package constructKPalindromeStrings;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        int c = 0;
        for (int value : charCountMap.values()) {
            if (value % 2 != 0) {
                c++;
            }
        }

        return c <= k;
    }
}
