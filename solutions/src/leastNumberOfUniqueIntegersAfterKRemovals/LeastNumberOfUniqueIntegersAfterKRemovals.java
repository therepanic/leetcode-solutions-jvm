package leastNumberOfUniqueIntegersAfterKRemovals;

import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int num : arr) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> nums = new ArrayList<>(numCountMap.values());

        Collections.sort(nums);

        int uniqCount = nums.size();

        for (int num : nums) {
            if (k >= num) {
                k -= num;
                uniqCount--;
            } else {
                break;
            }
        }

        return uniqCount;
    }
}
