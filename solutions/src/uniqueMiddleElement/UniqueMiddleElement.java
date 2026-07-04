package uniqueMiddleElement;

import java.util.HashMap;
import java.util.Map;

public class UniqueMiddleElement {
    public boolean isMiddleElementUnique(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int v : nums) {
            count.put(v, count.getOrDefault(v, 0) + 1);
        }
        return count.get(nums[nums.length / 2]) == 1;
    }
}
