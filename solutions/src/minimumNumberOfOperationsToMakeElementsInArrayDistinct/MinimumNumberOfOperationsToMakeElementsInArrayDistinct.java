package minimumNumberOfOperationsToMakeElementsInArrayDistinct;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    public static int minimumOperations(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        int c = 0;
        for (int num : nums) {
            int curCount = numCount.getOrDefault(num, 0) + 1;
            if (curCount > 1) {
                c++;
            }
            numCount.put(num, curCount);
        }
        int i = 0;
        int operations = 0;
        while (i < nums.length && c != 0) {
            int limit = Math.min(i + 3, nums.length);
            for (int j = i; j < limit; j++) {
                int count = numCount.get(nums[j]);
                if (count > 1) {
                    c--;
                }
                numCount.put(nums[j], count - 1);
            }
            operations++;
            i = limit;
        }
        return operations;
    }
}
