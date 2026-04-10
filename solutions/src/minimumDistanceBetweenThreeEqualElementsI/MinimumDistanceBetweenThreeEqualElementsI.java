package minimumDistanceBetweenThreeEqualElementsI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistanceBetweenThreeEqualElementsI {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            index.computeIfAbsent(nums[i], p -> new ArrayList<>()).add(i);
        }
        int min = Integer.MAX_VALUE;
        for (var entry : index.entrySet()) {
            for (int i = 0; i < entry.getValue().size() - 2; i++) {
                int a = Math.abs(entry.getValue().get(i) - entry.getValue().get(i + 1))
                        + Math.abs(entry.getValue().get(i + 1) - entry.getValue().get(i + 2))
                        + Math.abs(entry.getValue().get(i + 2) - entry.getValue().get(i));
                min = Math.min(a, min);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
