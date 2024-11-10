package lengthOfLongestSubarrayWithAtMostKFrequency;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        int maxSize = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            numCountMap.put(nums[r], numCountMap.getOrDefault(nums[r], 0) + 1);

            while (numCountMap.get(nums[r]) > k) {
                numCountMap.put(nums[l], numCountMap.get(nums[l]) - 1);
                l++;
            }

            maxSize = Math.max(maxSize, r - l + 1);
        }

        return maxSize;
    }
}
