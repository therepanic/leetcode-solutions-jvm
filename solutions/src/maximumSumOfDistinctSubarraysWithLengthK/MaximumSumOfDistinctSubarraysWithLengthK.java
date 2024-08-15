package maximumSumOfDistinctSubarraysWithLengthK;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;

        int l = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int notDistinctNumsInPool = 0;

        for (int r = 0; r < nums.length; r++) {
            if (map.containsKey(nums[r])) {
                map.put(nums[r], map.get(nums[r]) + 1);
            } else {
                map.put(nums[r], 1);
            }

            if (map.get(nums[r]) > 1) {
                notDistinctNumsInPool++;
            } else {
                currentSum += nums[r];
            }

            while (r - l + 1 > k) {
                if (map.containsKey(nums[l]) && map.get(nums[l]) > 1) {
                    map.put(nums[l], map.get(nums[l]) - 1);

                    notDistinctNumsInPool--;
                } else if (map.containsKey(nums[l])){
                    currentSum -= nums[l];
                    map.remove(nums[l]);
                }

                l++;
            }

            if (notDistinctNumsInPool == 0) {
                if (r - l + 1 == k) {
                    maxSum = Math.max(maxSum, currentSum);
                }
            }
        }

        return maxSum;
    }
}
