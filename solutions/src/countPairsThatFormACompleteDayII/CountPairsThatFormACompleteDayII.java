package countPairsThatFormACompleteDayII;

import java.util.HashMap;
import java.util.Map;

public class CountPairsThatFormACompleteDayII {
    public static long countCompleteDayPairs(int[] hours) {
        long count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int h : hours) {
            int r = (h % 24);
            int p = (24 - r) % 24;
            count += countMap.getOrDefault(r, 0);
            countMap.put(p, countMap.getOrDefault(p, 0) + 1);
        }
        return count;
    }
}
