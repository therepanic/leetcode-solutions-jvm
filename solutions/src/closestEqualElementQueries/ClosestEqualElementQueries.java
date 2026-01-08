package closestEqualElementQueries;

import java.util.*;

public class ClosestEqualElementQueries {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, Integer> valCountMap = new HashMap<>();
        Map<Integer, Integer> valIndexMap = new HashMap<>();
        Map<Integer, Integer> distances = new HashMap<>();
        for (int i = nums.length; i < nums.length * 3; i++) {
            int t = i % nums.length;
            valCountMap.put(nums[t], valCountMap.getOrDefault(nums[t], 0) + 1);
            if (!valIndexMap.containsKey(nums[t])) {
                valIndexMap.put(nums[t], i);
            } else {
                int it = valIndexMap.get(nums[t]);
                distances.put(it, Math.min(distances.getOrDefault(it, Integer.MAX_VALUE), i - it));
                distances.put(i, Math.min(distances.getOrDefault(i, Integer.MAX_VALUE), i - it));
                valIndexMap.put(nums[t], i);
            }
        }
        valIndexMap.clear();
        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            int t = i % nums.length;
            if (!valIndexMap.containsKey(nums[t])) {
                valIndexMap.put(nums[t], i);
            } else {
                int it = valIndexMap.get(nums[t]);
                distances.put(it, Math.min(distances.getOrDefault(it, Integer.MAX_VALUE), it - i));
                distances.put(i, Math.min(distances.getOrDefault(i, Integer.MAX_VALUE), it - i));
                valIndexMap.put(nums[t], i);
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if (valCountMap.get(nums[queries[i]]) == 2) {
                answer.add(-1);
                continue;
            }
            answer.add(distances.getOrDefault(queries[i] + nums.length, -1));
        }
        return answer;
    }
}
