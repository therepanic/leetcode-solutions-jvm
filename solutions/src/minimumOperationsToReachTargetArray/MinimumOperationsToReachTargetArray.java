package minimumOperationsToReachTargetArray;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperationsToReachTargetArray {
    public int minOperations(int[] nums, int[] target) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target[i]) {
                seen.add(nums[i]);
            }
        }
        return seen.size();
    }
}
