package minimumNumberOfOperationsToMakeWordKPeriodic;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeWordKPeriodic {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int l = 0;
        Map<String, Integer> strCountMap = new HashMap<>();
        int all = word.length() / k;
        int max = -1;
        for (int r = 0; r < word.length(); r++) {
            if (r - l + 1 == k) {
                String str = word.substring(l, r + 1);
                int c = strCountMap.getOrDefault(str, 0) + 1;
                max = Math.max(max, c);
                strCountMap.put(str,  c);
                l = r + 1;
            }
        }
        return all - max;
    }
}
