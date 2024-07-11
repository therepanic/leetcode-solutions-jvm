package minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        StringBuilder minWindowBuilder = new StringBuilder();
        String readyWindowBuilder = "";

        Map<Character, Integer> tCharacterCountMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            if (tCharacterCountMap.containsKey(c)) {
                tCharacterCountMap.put(c, tCharacterCountMap.get(c) + 1);
            } else {
                tCharacterCountMap.put(c, 1);
            }
        }

        Map<Character, Integer> sCharacterCountMap = new HashMap<>();
        char[] sChars = s.toCharArray();

        int l = 0;
        for (int r = 0; r < sChars.length; r++) {
            if (sCharacterCountMap.containsKey(sChars[r])) {
                int newValue = sCharacterCountMap.get(sChars[r]) + 1;

                sCharacterCountMap.put(sChars[r], newValue);
            } else {
                sCharacterCountMap.put(sChars[r], 1);
            }

            minWindowBuilder.append(sChars[r]);

            boolean sHasRightTCharacters = true;

            do {
                for (Map.Entry<Character, Integer> entry : tCharacterCountMap.entrySet()) {
                    if (!sCharacterCountMap.containsKey(entry.getKey()) || sCharacterCountMap.get(entry.getKey()) < entry.getValue()) {
                        sHasRightTCharacters = false;
                        break;
                    }
                }

                if (sHasRightTCharacters) {
                    if (sCharacterCountMap.get(sChars[l]) <= 1) {
                        sCharacterCountMap.remove(sChars[l]);
                    } else {
                        int newValue = sCharacterCountMap.get(sChars[l]) - 1;

                        sCharacterCountMap.put(sChars[l], newValue);
                    }

                    if (readyWindowBuilder.isEmpty() || readyWindowBuilder.length() > minWindowBuilder.length()) {
                        readyWindowBuilder = minWindowBuilder.toString();
                    }

                    minWindowBuilder.delete(0, 1);

                    l++;
                }

            } while (sHasRightTCharacters);
        }

        return readyWindowBuilder;
    }
}
