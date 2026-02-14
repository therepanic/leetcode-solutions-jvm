package numberOfPrefixConnectedGroups;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPrefixConnectedGroups {
    public int prefixConnected(String[] words, int k) {
        Map<String, Integer> prefCount = new HashMap<>();
        for (String word: words) {
            if (word.length() < k) continue;
            String pref = word.substring(0, k);
            prefCount.put(pref, prefCount.getOrDefault(pref, 0) + 1);
        }
        int sum = 0;
        for (var entry : prefCount.entrySet()) {
            if (entry.getValue() > 1) {
                sum++;
            }
        }
        return sum;
    }
}
