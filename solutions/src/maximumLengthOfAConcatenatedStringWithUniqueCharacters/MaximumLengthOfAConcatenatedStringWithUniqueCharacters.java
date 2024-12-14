package maximumLengthOfAConcatenatedStringWithUniqueCharacters;

import java.util.ArrayList;
import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public static int maxLength(List<String> arr) {
        List<String> combinations = new ArrayList<>();
        combinations.add("");

        int maxLen = 0;

        for (String s : arr) {
            if (!isUnique(s)) {
                continue;
            }

            List<String> newCombinations = new ArrayList<>();

            for (String existing : combinations) {
                String combined = existing + s;
                if (isUnique(combined)) {
                    newCombinations.add(combined);
                    maxLen = Math.max(maxLen, combined.length());
                }
            }

            combinations.addAll(newCombinations);
        }

        return maxLen;
    }

    private static boolean isUnique(String s) {
        boolean[] seen = new boolean[26];
        for (char c : s.toCharArray()) {
            if (seen[c - 'a']) {
                return false;
            }
            seen[c - 'a'] = true;
        }
        return true;
    }
}
