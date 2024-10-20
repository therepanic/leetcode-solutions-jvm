package longestWordInDictionary;

import java.util.*;

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        Arrays.sort(words);

        Set<String> wordSet = new HashSet<>(Set.of(""));
        String longestWord = "";

        for (String word : words) {
            String editedWord = word.substring(0, word.length() - 1);

            if (wordSet.contains(editedWord)) {
                wordSet.add(word);

                if (word.length() > longestWord.length() || word.length() == longestWord.length() && word.compareTo(longestWord) < 0) {
                    wordSet.add(word);
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }
}
