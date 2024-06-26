package containsDuplicate2;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numIndexMap.containsKey(nums[i]) && Math.abs(numIndexMap.get(nums[i]) - i) <= k) {
                return true;
            } else {
                numIndexMap.put(nums[i], i);
            }
        }

        return false;
    }
}
