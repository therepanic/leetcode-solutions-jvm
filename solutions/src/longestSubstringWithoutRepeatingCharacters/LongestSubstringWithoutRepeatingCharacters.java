package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        char[] sChars = s.toCharArray();
        int l = 0;

        int longestLength = 0;

        for (int r = 0; r < s.length(); r++) {
            if (!charSet.contains(sChars[r])) {
                charSet.add(sChars[r]);

                longestLength = Math.max(charSet.size(), longestLength);
            } else {
                while (charSet.contains(sChars[r])) {
                    charSet.remove(sChars[l]);
                    l++;
                }

                charSet.add(sChars[r]);
            }
        }

        longestLength = Math.max(longestLength, charSet.size());

        return longestLength;
    }
}
