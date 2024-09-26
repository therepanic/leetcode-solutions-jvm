package continuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, -1));

        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix = (nums[i] + prefix) % k;

            if (map.containsKey(prefix)) {
                if (i - map.get(prefix) > 1) {
                    return true;
                }
            } else {
                map.put(prefix, i);
            }
        }

        return false;
    }
}
