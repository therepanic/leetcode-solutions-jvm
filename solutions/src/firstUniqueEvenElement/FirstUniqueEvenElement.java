package firstUniqueEvenElement;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueEvenElement {
    public int firstUniqueEven(int[] nums) {
        Map<Integer, Integer> num = new LinkedHashMap<>();
        for (int i = 0; i  <nums.length; i++) {
            if (nums[i] % 2 == 0) {
                num.put(nums[i], num.getOrDefault(nums[i], 0) + 1);
            }
        }
        for (var entry : num.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
