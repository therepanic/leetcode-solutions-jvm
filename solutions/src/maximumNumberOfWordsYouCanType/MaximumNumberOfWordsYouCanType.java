package maximumNumberOfWordsYouCanType;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            chars.add(brokenLetters.charAt(i));
        }
        String[] words = text.split(" ");
        int c = words.length;
        first: for (int i = 0; i < words.length; i++) {
            for (char ch : chars) {
                if (words[i].indexOf(ch) >= 0) {
                    c--;
                    continue first;
                }
            }
        }
        return c;
    }
}
