package findTheLongestEqualSubarray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheLongestEqualSubarray {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int l = 0;
        int maxV = 0;
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int r = 0; r < nums.size(); r++) {
            Integer num = nums.get(r);
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
            maxV = Math.max(numCountMap.get(num), maxV);
            if (r - l + 1 - maxV > k) {
                numCountMap.put(nums.get(l), numCountMap.get(nums.get(l)) - 1);
                l++;
            }
        }
        return maxV;
    }
}
