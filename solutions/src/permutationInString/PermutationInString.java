package permutationInString;

import java.util.*;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1CharacterCountMap = new HashMap<>();
        Map<Character, Integer> s2CharacterCountMap = new HashMap<>();

        for (char c : s1.toCharArray()) {
            if (s1CharacterCountMap.containsKey(c)) {
                s1CharacterCountMap.put(c, s1CharacterCountMap.get(c) + 1);
            } else {
                s1CharacterCountMap.put(c, 1);
            }
        }

        char[] s2Chars = s2.toCharArray();
        int windowSize = s1.length();
        int l = 0;

        for (int r = 0; r < s2Chars.length; r++) {
            while (r - l + 1 > windowSize) {
                if (s2CharacterCountMap.get(s2Chars[l]) <= 1) {
                    s2CharacterCountMap.remove(s2Chars[l]);
                } else {
                    s2CharacterCountMap.put(s2Chars[l], s2CharacterCountMap.get(s2Chars[l]) - 1);
                }

                l++;
            }

            if (s2CharacterCountMap.containsKey(s2Chars[r])) {
                s2CharacterCountMap.put(s2Chars[r], s2CharacterCountMap.get(s2Chars[r]) + 1);
            } else {
                s2CharacterCountMap.put(s2Chars[r], 1);
            }

            if (s1CharacterCountMap.size() == s2CharacterCountMap.size()) {
                boolean withFailure = false;
                for (Map.Entry<Character, Integer> entry : s1CharacterCountMap.entrySet()) {
                    if (!s2CharacterCountMap.containsKey(entry.getKey()) || !s2CharacterCountMap.get(entry.getKey()).equals(entry.getValue())) {
                        withFailure = true;
                        break;
                    }
                }

                if (!withFailure) {
                    return true;
                }
            }
        }

        return false;
    }
}
