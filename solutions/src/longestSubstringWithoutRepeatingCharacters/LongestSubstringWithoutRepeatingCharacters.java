package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        char[] sChars = s.toCharArray();
        Set<Character> characters = new HashSet<>();
        int length = 0;

        int l = 0;
        int r = 0;

        while (r <= s.length() - 1) {
            if (!characters.contains(sChars[r])) {
                characters.add(sChars[r]);
                length = Math.max(characters.size(), length);
                r++;
            } else {
                while (characters.contains(sChars[r])) {
                    characters.remove(sChars[l]);
                    l++;
                }
            }
        }

        return length;
    }
}
