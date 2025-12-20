package minimumNumberOfOperationsToHaveDistinctElements;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToHaveDistinctElements {

    public static int minOperations(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int distinct = 0;
        for (int val : nums) {
            int c = countMap.getOrDefault(val, 0);
            countMap.put(val, c + 1);
            if (c == 1) {
                distinct++;
            }
        }
        int count = 0;
        int q = nums.length / 3 + 1;
        int it = 0;
        for (int i = 0; i < q && it < nums.length && distinct != 0; i++) {
            for (int j = 0; j < 3 && it < nums.length && distinct != 0; j++) {
                countMap.compute(nums[it], (_, p2) -> p2 - 1 == 0 ? null : p2 - 1);
                if (countMap.containsKey(nums[it]) && countMap.get(nums[it]).equals(1)) {
                    distinct--;
                }
                it++;
            }
            count++;
        }
        return count;
    }
}
