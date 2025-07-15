package majorityElementII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        int appearance = nums.length / 3;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int val : nums) {
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }
        List<Integer> values = new ArrayList<>();
        for (var entry : countMap.entrySet()) {
            if (entry.getValue() > appearance) {
                values.add(entry.getKey());
            }
        }
        return values;
    }

}
