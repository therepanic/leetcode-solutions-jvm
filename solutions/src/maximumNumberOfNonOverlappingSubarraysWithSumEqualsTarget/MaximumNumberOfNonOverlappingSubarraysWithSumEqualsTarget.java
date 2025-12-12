package maximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget {
    public int maxNonOverlapping(int[] nums, int target) {
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> prefMap = new HashMap<>(Map.of(0, 0));
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefMap.containsKey(sum - target)) {
                ans = Math.max(ans, prefMap.get(sum - target) + 1);
            }
            prefMap.put(sum, ans);
        }
        return ans;
    }
}
