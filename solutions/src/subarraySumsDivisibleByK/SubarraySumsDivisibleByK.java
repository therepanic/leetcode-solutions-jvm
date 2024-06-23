package subarraySumsDivisibleByK;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            int sumValue = sum % k;

            if (sumValue < 0) {
                sumValue += k;
            }

            if (map.containsKey(sumValue)) {
                count += map.get(sumValue);
                map.put(sumValue, map.get(sumValue) + 1);
            } else {
                map.put(sumValue, 1);
            }

        }

        return count;
    }
}
