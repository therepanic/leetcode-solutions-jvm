package leastNumberOfUniqueIntegersAfterKRemovals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int num : arr) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> nums = new PriorityQueue<>(Comparator.comparingInt((p1) -> p1[1]));

        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            nums.add(new int[] {entry.getKey(), entry.getValue()});
        }

        for (int i = 0; i < k && !nums.isEmpty(); i++) {
            int[] result = nums.poll();

            if (result[1] - 1 == 0) {
                numCountMap.remove(result[0]);
            } else {
                nums.add(new int[] {result[0], --result[1]});
            }
        }

        return nums.size();
    }
}
