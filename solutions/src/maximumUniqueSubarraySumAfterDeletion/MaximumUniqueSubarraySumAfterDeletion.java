package maximumUniqueSubarraySumAfterDeletion;

import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSubarraySumAfterDeletion {
    public int maxSum(int[] nums) {
        Set<Integer> uniqNums = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int val : nums) {
            max = Math.max(val, max);
            if (val > 0) {
                uniqNums.add(val);
            }
        }
        if (uniqNums.isEmpty()) {
            return max;
        }
        int sum = 0;
        for (int val : uniqNums) {
            sum += val;
        }
        return sum;
    }
}
