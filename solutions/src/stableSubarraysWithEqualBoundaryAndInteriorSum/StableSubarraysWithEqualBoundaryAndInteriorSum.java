package stableSubarraysWithEqualBoundaryAndInteriorSum;

import java.util.HashMap;
import java.util.Map;

public class StableSubarraysWithEqualBoundaryAndInteriorSum {
    public long countStableSubarrays(int[] capacity) {
        Map<Long, Map<Long, Long>> mmp = new HashMap<>();
        long ans = 0;
        long prefix = 0;
        for (int i = 0; i < capacity.length; i++) {
            if (mmp.containsKey((long) capacity[i])) {
                Map<Long, Long> map = mmp.get((long) capacity[i]);
                Long count = map.get(prefix - capacity[i]);
                if (count != null) {
                    ans += count;
                }
            }
            prefix += capacity[i];
            Map<Long, Long> temp = mmp.computeIfAbsent((long) capacity[i], (p) -> new HashMap<>());
            temp.put(prefix, temp.getOrDefault(prefix, 0L) + 1);
            if (i > 0 && capacity[i] == 0 && capacity[i - 1] == 0) {
                ans--;
            }
        }
        return ans;
    }
}
