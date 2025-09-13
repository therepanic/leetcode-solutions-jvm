package minimumDiscardsToBalanceInventory;

import java.util.HashMap;
import java.util.Map;

public class MinimumDiscardsToBalanceInventory {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        Map<Integer, Integer> cMap = new HashMap<>();
        int l = 0;
        boolean[] kept = new boolean[arrivals.length];
        int count = 0;
        for (int r = 0; r < arrivals.length; r++) {
            if (r - l >= w) {
                if (kept[l]) {
                    cMap.compute(arrivals[l], (key, val) -> (val == null || val == 1) ? null : val - 1);
                }
                l++;
            }
            int c = cMap.getOrDefault(arrivals[r], 0);
            if (c >= m) {
                count++;
                kept[r] = false;
            } else {
                cMap.put(arrivals[r], c + 1);
                kept[r] = true;
            }
        }
        return count;
    }
}
