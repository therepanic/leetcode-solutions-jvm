package countWordsObtainedAfterAddingALetter;

import java.util.*;

public class CountWordsObtainedAfterAddingALetter {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> masks = new HashSet<>();
        for (int i = 0; i < startWords.length; i++) {
            int mask = 0;
            for (int j = 0; j < startWords[i].length(); j++) {
                mask |= (1 << (startWords[i].charAt(j) - 'a'));
            }
            for (int j = 0; j < 26; j++) {
                if ((mask & (1 << (j))) == 0) {
                    masks.add(mask | (1 << j));
                }
            }
        }
        int c = 0;
        for (int i = 0; i < targetWords.length; i++) {
            int mask = 0;
            for (int j = 0; j < targetWords[i].length(); j++) {
                mask |= (1 << (targetWords[i].charAt(j) - 'a'));
            }
            c += masks.contains(mask) ? 1 : 0;
        }
        return c;
    }
}
