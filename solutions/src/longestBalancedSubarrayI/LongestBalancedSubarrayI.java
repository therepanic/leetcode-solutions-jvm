package longestBalancedSubarrayI;

import java.util.HashMap;
import java.util.Map;

public class LongestBalancedSubarrayI {
    public int longestBalanced(int[] nums) {
        for (int i = nums.length; i > 0; i--) {
            int l = 0;
            Map<Integer, Integer> even = new HashMap<>();
            Map<Integer, Integer> odd = new HashMap<>();
            for (int r = 0; r < nums.length; r++) {
                if (nums[r] % 2 == 0) {
                    even.put(nums[r], even.getOrDefault(nums[r], 0) + 1);
                } else {
                    odd.put(nums[r], odd.getOrDefault(nums[r], 0) + 1);
                }
                if (r - l + 1 > i) {
                    if (nums[l] % 2 == 0) {
                        even.compute(nums[l], (key, v) -> v == 1 ? null : v - 1);
                    } else {
                        odd.compute(nums[l], (key, v) -> v == 1 ? null : v - 1);
                    }
                    l++;
                }
                if (r - l + 1 == i && even.size() == odd.size()) {
                    return r - l + 1;
                }
            }
        }
        return 0;
    }
}
