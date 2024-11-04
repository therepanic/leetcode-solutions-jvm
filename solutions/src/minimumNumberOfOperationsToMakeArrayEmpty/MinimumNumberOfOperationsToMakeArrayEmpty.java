package minimumNumberOfOperationsToMakeArrayEmpty;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeArrayEmpty {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> taskCountMap = new HashMap<>();

        for (int task : nums) {
            taskCountMap.put(task, taskCountMap.getOrDefault(task, 0) + 1);
        }

        int count = 0;

        for (int value : taskCountMap.values()) {
            if (value == 1) {
                return -1;
            }

            if (value % 3 == 0) {
                count += value / 3;
            } else {
                count += value / 3 + 1;
            }
        }

        return count;
    }
}
