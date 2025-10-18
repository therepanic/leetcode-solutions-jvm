package maximumNumberOfDistinctElementsAfterOperations;

import java.util.Arrays;

public class MaximumNumberOfDistinctElementsAfterOperations {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = Math.min(nums[i] + k, Math.max(prev + 1, nums[i] - k));
            if (current > prev) {
                prev = current;
                c++;
            }
        }
        return c;
    }
}
