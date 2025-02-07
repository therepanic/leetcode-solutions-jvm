package findTheNumberOfDistinctColorsAmongTheBalls;

import java.util.HashMap;
import java.util.Map;

public class FindTheNumberOfDistinctColorsAmongTheBalls {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> fromMap = new HashMap<>();
        int[] answer = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            if (fromMap.containsKey(query[0])) {
                int key = fromMap.get(query[0]);
                countMap.put(key, countMap.get(key) - 1);
                if (countMap.get(key) == 0) countMap.remove(key);
            }
            countMap.put(query[1], countMap.getOrDefault(query[1], 0) + 1);
            fromMap.put(query[0], query[1]);
            answer[i] = countMap.size();
            i++;
        }
        return answer;
    }
}
