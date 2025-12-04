package longestPalindromeByConcatenatingTwoLetterWords;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        int c = 0;
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        boolean palindrome = false;
        for (var entry : countMap.entrySet()) {
            String reversed = new StringBuilder(entry.getKey()).reverse().toString();
            if (entry.getKey().equals(reversed)) {
                int v = entry.getValue() / 2 * 4;
                if (entry.getValue() % 2 == 1) {
                    palindrome = true;
                }
                c += v;
            } else if (entry.getKey().compareTo(reversed) < 0 && countMap.containsKey(reversed)) {
                c += Math.min(countMap.get(entry.getKey()), countMap.getOrDefault(reversed, 0)) * 4;
            }
        }
        if (palindrome) {
            c += 2;
        }
        return c;
    }
}
