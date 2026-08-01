package widestPossibleFence;

import java.util.HashMap;
import java.util.Map;

public class WidestPossibleFence {
    public int maximumWidth(int[] planks) {
        Map<Integer, Integer> heights = new HashMap<>();
        for (int i = 0; i < planks.length; i++) {
            heights.put(planks[i], heights.getOrDefault(planks[i], 0) + 1);
        }
        Map<Integer, Integer> width = new HashMap<>(heights);
        for (int a : heights.keySet()) {
            for (int b : heights.keySet()) {
                if (a > b) continue;
                int cnt;
                if (a == b) {
                    cnt = heights.get(a) / 2;
                } else {
                    cnt = Math.min(heights.get(a), heights.get(b));
                }
                int sum = a + b;
                width.put(sum, width.getOrDefault(sum, 0) + cnt);
            }
        }
        int ans = 0;
        for (int w : width.values()) {
            ans = Math.max(ans, w);
        }
        return ans;
    }
}
