package subarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>(Map.of(0, 1));

        int total = 0;
        int curNum = 0;

        for (int num : nums) {
            curNum += num;

            if (prefixSum.containsKey(curNum - k)) {
                total += prefixSum.get(curNum - k);
            }

            if (!prefixSum.containsKey(curNum)) {
                prefixSum.put(curNum, 1);
            } else {
                prefixSum.put(curNum, prefixSum.get(curNum) + 1);
            }
        }

        return total;
    }
}
