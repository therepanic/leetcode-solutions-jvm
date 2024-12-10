package determineIfTwoStringsAreClose;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] word1Count = new int[26];

        for (char c : word1.toCharArray()) {
            word1Count[c - 'a']++;
        }

        Map<Integer, Integer> counts = new HashMap<>();

        for (int c : word1Count) {
            if (c > 0) counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int[] word2Count = new int[26];

        for (char c : word2.toCharArray()) {
            word2Count[c - 'a']++;
        }

        for (int i = 0; i < word2Count.length; i++) {
            int count = word2Count[i];

            if (count > 0 && word1Count[i] <= 0) return false;

            if (count > 0 && !counts.containsKey(count)) {
                return false;
            }
            if (counts.containsKey(count)) {
                if (counts.get(count) > 1) {
                    counts.put(count, counts.get(count) - 1);
                } else {
                    counts.remove(count);
                }
            }
        }

        return true;
    }
}
