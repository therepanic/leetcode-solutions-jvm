package findTheMostCommonResponse;

import java.util.*;

public class FindTheMostCommonResponse {
    public static String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        for (List<String> r : responses) {
            Set<String> response = new HashSet<>(r);
            for (String str : response) {
                int count = countMap.getOrDefault(str, 0) + 1;
                maxCount = Math.max(count, maxCount);
                countMap.put(str, count);
            }
        }
        List<String> strs = new ArrayList<>();
        for (var entry : countMap.entrySet()) {
            if (entry.getValue().equals(maxCount)) {
                strs.add(entry.getKey());
            }
        }
        Collections.sort(strs);
        return strs.getFirst();
    }
}
