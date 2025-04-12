package countTheNumberOfGoodSubarrays;

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfGoodSubarrays {
    public static long countGood(int[] nums, int k) {
        long all = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        int good = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            int val = countMap.getOrDefault(nums[r], 0);
            good += val;
            countMap.put(nums[r], val + 1);
            while (good >= k) {
                val = countMap.get(nums[l]) - 1;
                countMap.put(nums[l], val);
                good -= val;
                l++;
                all += (nums.length - r);
            }
        }
        return all;
    }
}
