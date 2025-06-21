package minimumDeletionsToMakeStringKSpecial;

import java.util.*;

public class MinimumDeletionsToMakeStringKSpecial {

    public static int minimumDeletions(String word, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        int answer = word.length();
        for (int a : charMap.values()) {
            int deleted = 0;
            for (int b : charMap.values()) {
                if (a > b) {
                    deleted += b;
                } else if (b > a + k) {
                    deleted += b - (a + k);
                }
            }
            answer = Math.min(answer, deleted);
        }
        return answer;
    }

}
