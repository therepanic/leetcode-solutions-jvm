package maximumScoreWordsFormedByLetters;

import java.util.HashMap;
import java.util.Map;

public class MaximumScoreWordsFormedByLetters {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character, Integer> lettersMap = new HashMap<>();
        for (char c : letters) {
            lettersMap.put(c, lettersMap.getOrDefault(c, 0) + 1);
        }
        int[] count = new int[1];
        bypass(words, lettersMap, score, 0, 0, count);
        return count[0];
    }

    private void bypass(String[] words, Map<Character, Integer> letters, int[] score, int it, int curScore, int[] count) {
        if (it == words.length) {
            count[0] = Math.max(count[0], curScore);
            return;
        }
        bypass(words, letters, score, it + 1, curScore, count);
        String word = words[it];
        Map<Character, Integer> clone = new HashMap<>(letters);
        for (int i = 0; i < word.length(); i++) {
            if (clone.getOrDefault(word.charAt(i), 0) == 0) return;
            clone.put(word.charAt(i), clone.get(word.charAt(i)) - 1);
            curScore += score[word.charAt(i) - 'a'];
        }
        bypass(words, clone, score, it + 1, curScore, count);
    }
}
