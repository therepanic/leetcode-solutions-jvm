package longestStrictlyIncreasingSubsequenceWithNonZeroBitwiseAND;

import java.util.ArrayList;
import java.util.List;

public class LongestStrictlyIncreasingSubsequenceWithNonZeroBitwiseAND {
    public static int longestSubsequence(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 30; i++) {
            List<Integer> vals = new ArrayList<>();
            for (int val : nums) {
                if ((val & (1 << i)) != 0) {
                    vals.add(val);
                }
            }
            ans = Math.max(ans, lis(vals));
        }
        return ans;
    }

    public static int lis(List<Integer> nums) {
        List<Integer> dp = new ArrayList<>();
        for (int v : nums) {
            int p = low(dp, v);
            if (p == dp.size()) {
                dp.add(v);
            } else {
                dp.set(p, v);
            }
        }
        return dp.size();
    }

    public static int low(List<Integer> values, int target) {
        int low = 0;
        int high = values.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (values.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
