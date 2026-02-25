package sortArrayByIncreasingFrequency;

import java.util.*;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int val : nums) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        }
        List<int[]> toSort = new ArrayList<>();
        int c = 0;
        for (var entry : freqMap.entrySet()) {
            toSort.add(new int[] {entry.getKey(), entry.getValue()});
            c += entry.getValue();
        }
        toSort.sort((p1, p2) -> {
            if (p1[1] == p2[1]) {
                return Integer.compare(p2[0], p1[0]);
            } else {
                return Integer.compare(p1[1], p2[1]);
            }
        });
        int[] ans = new int[c];
        int it = 0;
        for (int i = 0; i < ans.length; i++) {
            while (toSort.get(it)[1] == 0) {
                it++;
            }
            ans[i] = toSort.get(it)[0];
            toSort.get(it)[1]--;
        }
        return ans;
    }
}
