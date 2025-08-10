package destroySequentialTargets;

import java.util.HashMap;
import java.util.Map;

public class DestroySequentialTargets {

    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 0;
        for (int val : nums) {
            int v = val % space;
            int c = countMap.getOrDefault(v, 0) + 1;
            max = Math.max(max, c);
            countMap.put(v, c);
        }
        int ans = Integer.MAX_VALUE;
        for (int val : nums) {
            if (countMap.get(val % space) == max) {
                ans = Math.min(ans, val);
            }
        }
        return ans;
    }
}
