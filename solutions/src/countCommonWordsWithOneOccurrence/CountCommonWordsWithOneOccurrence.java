package countCommonWordsWithOneOccurrence;

import java.util.HashMap;
import java.util.Map;

public class CountCommonWordsWithOneOccurrence {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> first = new HashMap<>();
        Map<String, Integer> second = new HashMap<>();
        for (String w : words1) {
            first.put(w, first.getOrDefault(w, 0) + 1);
        }
        for (String w : words2) {
            second.put(w, second.getOrDefault(w, 0) + 1);
        }
        int a = 0;
        for (var entry : first.entrySet()) {
            if (second.getOrDefault(entry.getKey(), -1) == 1 && entry.getValue() == 1) {
                a++;
            }
        }
        return a;
    }
}
