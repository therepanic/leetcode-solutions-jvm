package contiguousArray;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, -1));

        int maxLength = 0;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k -= 1;
            } else {
                k += 1;
            }

            if (!map.containsKey(k)) {
                map.put(k, i);
            } else {
                maxLength = Math.max(maxLength, i - map.get(k));
            }
        }

        return maxLength;
    }
}
