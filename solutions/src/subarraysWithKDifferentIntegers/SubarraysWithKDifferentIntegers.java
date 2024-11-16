package subarraysWithKDifferentIntegers;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return mastodon(nums, k) - mastodon(nums, k - 1);
    }
    public int mastodon(int[] nums, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        int subCount = 0;

        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            numCountMap.put(nums[r],
                    numCountMap.getOrDefault(nums[r], 0) + 1);

            while (numCountMap.size() > k) {
                if (numCountMap.get(nums[l]) - 1 > 0) {
                    numCountMap.put(nums[l], numCountMap.get(nums[l]) - 1);
                } else {
                    numCountMap.remove(nums[l]);
                }

                l++;
            }
            subCount += r - l + 1;
        }

        return subCount;
    }
}
