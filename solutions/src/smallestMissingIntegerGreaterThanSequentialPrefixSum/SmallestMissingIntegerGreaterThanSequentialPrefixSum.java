package smallestMissingIntegerGreaterThanSequentialPrefixSum;

import java.util.HashSet;
import java.util.Set;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        Set<Integer> all = new HashSet<>();
        for (int num : nums) {
            all.add(num);
        }
        for (int i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++) {
            sum += nums[i];
        }
        while (all.contains(sum)) {
            sum++;
        }
        return sum;
    }
}
