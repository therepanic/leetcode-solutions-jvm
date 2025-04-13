package longestSubstringOfAllVowelsInOrder;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringOfAllVowelsInOrder {

    public static int longestBeautifulSubstring(String word) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        char[] wordChars = word.toCharArray();
        int l = 0;
        int answer = 0;
        for (int r = 0; r < wordChars.length; r++) {
            int val = charCount.getOrDefault(wordChars[r], 0) + 1;
            charCount.remove(wordChars[r]);
            charCount.put(wordChars[r], val);
            while (!check(charCount)) {
                charCount.put(wordChars[l], charCount.get(wordChars[l]) - 1);
                if (charCount.get(wordChars[l]) == 0) {
                    charCount.remove(wordChars[l]);
                }
                l++;
            }
            if (charCount.size() == 5) {
                answer = Math.max(r - l + 1, answer);
            }
        }
        return answer;
    }

    public static boolean check(Map<Character, Integer> charCount) {
        int i = 0;
        for (char c : charCount.keySet()) {
            if (get(c) != i) return false;
            i++;
        }
        return true;
    }

    public static int get(char ch) {
        return switch (ch) {
            case 'a' -> 0;
            case 'e' -> 1;
            case 'i' -> 2;
            case 'o' -> 3;
            case 'u' -> 4;
            default -> throw new IllegalStateException("Unexpected value: " + ch);
        };
    }

}
