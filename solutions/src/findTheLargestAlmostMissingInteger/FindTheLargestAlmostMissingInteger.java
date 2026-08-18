package findTheLargestAlmostMissingInteger;

import java.util.HashMap;
import java.util.Map;

public class FindTheLargestAlmostMissingInteger {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> window = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            window.put(nums[r], window.getOrDefault(nums[r], 0) + 1);
            if (r - l + 1 == k) {
                for (int v : window.keySet()) {
                    count.put(v, count.getOrDefault(v, 0) + 1);
                }
                window.compute(nums[l], (_, v) -> v == 1 ? null : v - 1);
                l++;
            }
        }
        int max = -1;
        for (var entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                max = Math.max(max, entry.getKey());
            }
        }
        return max;
    }
}
