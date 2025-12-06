package partitionArrayIntoKDistinctGroups;

import java.util.HashMap;
import java.util.Map;

public class PartitionArrayIntoKDistinctGroups {
    public boolean partitionArray(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        int groupCount = nums.length / k;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int val : nums) {
            if (countMap.containsKey(val) && countMap.get(val).equals(groupCount)) {
                return false;
            }
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }
        return true;
    }
}
