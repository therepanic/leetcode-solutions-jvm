package maximumErasureValue;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int l = 0;

        int maxSize = 0;
        int curMaxSize = 0;
        for (int r = 0; r < nums.length; r++) {
            while (numSet.contains(nums[r])) {
                curMaxSize -= nums[l];
                numSet.remove(nums[l]);
                l++;
            }

            curMaxSize += nums[r];
            numSet.add(nums[r]);

            maxSize = Math.max(curMaxSize, maxSize);
        }

        return maxSize;
    }
}
