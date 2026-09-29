package rearrangeArrayByRemovingDistinctValues;

import java.util.*;

public class RearrangeArrayByRemovingDistinctValues {
    public int[] rearrangeArray(int[] nums) {
        Map<Integer, Integer> valMap = new TreeMap<>();
        for (int v : nums) {
            valMap.put(v, valMap.getOrDefault(v, 0) + 1);
        }
        int[] ans = new int[nums.length];
        int i = 0;
        while (!valMap.isEmpty()) {
            List<Integer> toDel = new ArrayList<>();
            for (var entry : valMap.entrySet()) {
                if (entry.getValue() == 0) {
                    toDel.add(entry.getKey());
                } else {
                    ans[i] = entry.getKey();
                    valMap.put(entry.getKey(), entry.getValue() - 1);
                    i++;
                }
            }
            for (int a : toDel) {
                valMap.remove(a);
            }
        }
        return ans;
    }
}
