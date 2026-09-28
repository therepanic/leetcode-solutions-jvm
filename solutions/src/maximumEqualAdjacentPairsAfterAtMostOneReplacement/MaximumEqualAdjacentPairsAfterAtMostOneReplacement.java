package maximumEqualAdjacentPairsAfterAtMostOneReplacement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumEqualAdjacentPairsAfterAtMostOneReplacement {
    public int maxEqualAdjacentPairs(int[] nums) {
        Map<List<Integer>, Integer> countMap = new HashMap<>();
        int c = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                c++;
            } else {
                countMap.put(List.of(nums[i], nums[i + 1]), countMap.getOrDefault(List.of(nums[i], nums[i + 1]), 0) + 1);
                countMap.put(List.of(nums[i + 1], nums[i]), countMap.getOrDefault(List.of(nums[i + 1], nums[i]), 0) + 1);
            }
        }
        int ans = 0;
        for (int max : countMap.values()) {
            ans = Math.max(max, ans);
        }
        return ans + c;
    }
}
