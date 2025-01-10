package wordSubsets;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] count = new int[26];

        for (String word : words2) {
            int[] chars = new int[26];

            for (char ch : word.toCharArray()) {
                chars[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i], chars[i]);
            }
        }

        List<String> words = new ArrayList<>();

        first: for (String word : words1) {
            int[] chars = new int[26];

            for (char ch : word.toCharArray()) {
                chars[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (count[i] > chars[i]) {
                    continue first;
                }
            }

            words.add(word);
        }
        return words;
    }
}
