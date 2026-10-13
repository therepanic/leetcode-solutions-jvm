package longestResilientSubarrayI;

import java.util.HashMap;
import java.util.Map;

public class LongestResilientSubarrayI {
    public int resilientSubarray(int[] nums, int k) {
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            Map<Integer, Integer> div = new HashMap<>();
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                int a = nums[j] % k;
                div.put(a, div.getOrDefault(a, 0) + 1);
                if (j - i + 1 == div.getOrDefault(sum % k, 0)) {
                    ans = Math.max(j - i + 1, ans);
                }
            }
        }
        return ans;
    }
}
