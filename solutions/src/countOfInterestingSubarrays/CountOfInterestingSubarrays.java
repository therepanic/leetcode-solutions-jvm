package countOfInterestingSubarrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfInterestingSubarrays {
    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % modulo == k) {
                sum++;
            }
            int sumValue = (sum + modulo) % modulo;
            count += map.getOrDefault((sum - k + modulo) % modulo, 0);
            map.put(sumValue, map.getOrDefault(sumValue, 0) + 1);
        }
        return count;
    }
}
