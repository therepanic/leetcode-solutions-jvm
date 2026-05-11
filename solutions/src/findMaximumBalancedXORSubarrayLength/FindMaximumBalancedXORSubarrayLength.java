package findMaximumBalancedXORSubarrayLength;

import java.util.HashMap;
import java.util.Map;

public class FindMaximumBalancedXORSubarrayLength {
    public int maxBalancedSubarray(int[] nums) {
        int[][] prefix = new int[nums.length][2];
        Map<String, Integer> map = new HashMap<>(Map.of("0-0", -1));
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix[i][0] = (i > 0 ? prefix[i-1][0] : 0) ^ nums[i];
            prefix[i][1] = (i > 0 ? prefix[i-1][1] : 0) + (nums[i] % 2 == 0 ? 1 : -1);
            String key = prefix[i][1] + "-" + prefix[i][0];
            if (map.containsKey(key)) {
                ans = Math.max(ans, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return ans;
    }
}
