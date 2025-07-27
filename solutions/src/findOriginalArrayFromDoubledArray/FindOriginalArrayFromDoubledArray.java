package findOriginalArrayFromDoubledArray;

import java.util.*;

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int val : changed) {
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }
        int[] answer = new int[changed.length / 2];
        int it = 0;
        List<Map.Entry<Integer, Integer>> copy = new ArrayList<>(countMap.entrySet());
        copy.sort(Comparator.comparingInt(Map.Entry::getKey));
        for (var entry : copy) {
            int min = countMap.getOrDefault(entry.getKey(), 0);
            if (min == 0) continue;
            if (entry.getKey() == 0) {
                if (min % 2 != 0) return new int[0];
                for (int i = 0; i < min / 2; i++) {
                    answer[it++] = 0;
                }
                countMap.put(0, 0);
                continue;
            }
            if (countMap.getOrDefault(entry.getKey() * 2, 0) < min) {
                return new int[] {};
            } else {
                countMap.put(entry.getKey(), 0);
                countMap.compute(entry.getKey() * 2, (key, value) -> value - min == 0 ? null : value - min);
                for (int i = 0; i < min; i++) {
                    answer[it] = entry.getKey();
                    it++;
                }
            }
        }
        return answer;
    }
}
