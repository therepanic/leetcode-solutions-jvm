package numberOfAlternatingXORPartitions;

import java.util.HashMap;
import java.util.Map;

public class NumberOfAlternatingXORPartitions {
    public int alternatingXOR(int[] nums, int target1, int target2) {
        Map<Integer, Long> sum1 = new HashMap<>();
        Map<Integer, Long> sum2 = new HashMap<>();
        sum2.put(0, 1L);
        int px = 0;
        long dp1 = 0;
        long dp2 = 0;
        for (int v : nums) {
            px ^= v;
            dp1 = sum2.getOrDefault(px ^ target1, 0L);
            dp2 = sum1.getOrDefault(px ^ target2, 0L);
            if (dp1 != 0) {
                sum1.put(px, (sum1.getOrDefault(px, 0L) + dp1) % 1_000_000_007);
            }
            if (dp2 != 0) {
                sum2.put(px, (sum2.getOrDefault(px, 0L) + dp2) % 1_000_000_007);
            }
        }
        return (int) ((dp1 + dp2) % 1_000_000_007);
    }
}
