package countNumberOfBadPairs;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> valueCountMap = new HashMap<>();
        long allPairs = ((long) nums.length * (nums.length - 1)) / 2;
        for (int i = 0; i < nums.length; i++) {
            int val = i - nums[i];
            int suf = valueCountMap.getOrDefault(val, 0);
            allPairs -= suf;
            valueCountMap.put(val, suf + 1);
        }
        return allPairs;
    }
}
