package longestNiceSubstring;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        char[] sChars = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for (char c : sChars) {
            charSet.add(c);
        }
        for (int i = 0; i < s.length(); i++) {
            if (charSet.contains(Character.toUpperCase(sChars[i])) && charSet.contains(Character.toLowerCase(sChars[i]))) {
                continue;
            }
            String first = longestNiceSubstring(s.substring(0, i));
            String second = longestNiceSubstring(s.substring(i + 1));
            return first.length() >= second.length() ? first : second;
        }
        return s;
    }
}
