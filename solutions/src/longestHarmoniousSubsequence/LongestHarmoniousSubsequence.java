package longestHarmoniousSubsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numCountMap.put(nums[i], numCountMap.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        for (var entry : numCountMap.entrySet()) {
            if (numCountMap.containsKey(entry.getKey() - 1)) {
                max = Math.max(entry.getValue() + numCountMap.get(entry.getKey() - 1), max);
            }
        }
        return max;
    }

}
