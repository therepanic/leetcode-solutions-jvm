package topKFrequentElements;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numExistanceMap = new HashMap<>();

        for (int i : nums) {
            if (numExistanceMap.containsKey(i)) {
                numExistanceMap.put(i, numExistanceMap.get(i) + 1);
            } else {
                numExistanceMap.put(i, 1);
            }
        }

        int[] newNums = new int[k];

        for (int i = 0; i < k; i++) {
            int minValue = -1;
            int minNum = -1;

            for (Map.Entry<Integer, Integer> entry : numExistanceMap.entrySet()) {
                if (entry.getValue() > minValue) {
                    minValue = entry.getValue();
                    minNum = entry.getKey();
                }
            }

            numExistanceMap.remove(minNum);
            newNums[i] = minNum;
        }

        return newNums;
    }
}
