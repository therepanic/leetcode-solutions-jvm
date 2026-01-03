package minimumSubarrayLengthWithDistinctSumAtLeastK;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubarrayLengthWithDistinctSumAtLeastK {
    public static int minLength(int[] nums, long k) {
        int l = 0;
        long sum = 0;
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int r = 0; r < nums.length; r++) {
            int x = nums[r];
            int c = freq.getOrDefault(x, 0);
            if (c == 0) sum += x;
            freq.put(x, c + 1);
            while (sum >= k) {
                ans = Math.min(ans, r - l + 1);
                int y = nums[l];
                int cy = freq.get(y) - 1;
                if (cy == 0) {
                    sum -= y;
                }
                freq.put(y, cy);
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
