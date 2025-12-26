package minimumArrayLengthAfterPairRemovals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumArrayLengthAfterPairRemovals {
    public int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < nums.size(); i++) {
            int v = countMap.getOrDefault(nums.get(i), 0) + 1;
            countMap.put(nums.get(i), v);
            maxFreq = Math.max(maxFreq, v);
        }
        if (maxFreq <= nums.size() / 2) {
            if (nums.size() % 2 == 1) {
                return 0;
            } else {
                return 1;
            }
        }
        return 2 * maxFreq - nums.size();
    }
}
