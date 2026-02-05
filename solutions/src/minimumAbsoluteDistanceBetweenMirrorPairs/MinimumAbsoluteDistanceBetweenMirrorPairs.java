package minimumAbsoluteDistanceBetweenMirrorPairs;

import java.util.*;

public class MinimumAbsoluteDistanceBetweenMirrorPairs {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int minD = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (lastIndex.containsKey(val)) {
                minD = Math.min(minD, i - lastIndex.get(val));
            }
            int rev = reverse(val);
            lastIndex.put(rev, i);
        }

        return minD == Integer.MAX_VALUE ? -1 : minD;
    }

    public static int reverse(int val) {
        int ans = 0;
        while (val != 0) {
            ans *= 10;
            ans += val % 10;
            val /= 10;
        }
        return ans;
    }
}
