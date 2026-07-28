package countPathsWithTheGivenXORValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RemovalsToAchieveTargetXOR {
    public int minRemovals(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>(Map.of(0, 0));
        for (int a : nums) {
            target ^= a;
            var copy = new ArrayList<>(dp.entrySet());
            for (var entry : copy) {
                int v = entry.getKey();
                int c = entry.getValue();
                int nextV = v ^ a;
                if (c + 1 < dp.getOrDefault(nextV, Integer.MAX_VALUE)) {
                    dp.put(nextV, c + 1);
                }
            }
        }
        return dp.getOrDefault(target, -1);
    }
}
