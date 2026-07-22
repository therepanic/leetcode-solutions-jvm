package prefixAndSuffixSearch;

import java.util.HashMap;
import java.util.Map;

public class WordFilter {

    private final Map<String, Integer> precomputed = new HashMap<>();

    public WordFilter(String[] words) {
        for (int it = 0; it < words.length; it++) {
            String word = words[it];
            for (int i = 1; i <= word.length(); i++) {
                String p = word.substring(0, i);
                for (int j = 0; j <= word.length(); j++) {
                    String d = word.substring(j);
                    this.precomputed.put(p + "|" + d, it);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return this.precomputed.getOrDefault(pref + "|" + suff, -1);
    }
}
