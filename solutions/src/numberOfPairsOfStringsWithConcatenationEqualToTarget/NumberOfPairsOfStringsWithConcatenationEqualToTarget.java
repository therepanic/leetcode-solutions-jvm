package numberOfPairsOfStringsWithConcatenationEqualToTarget;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsOfStringsWithConcatenationEqualToTarget {
    public int numOfPairs(String[] nums, String target) {
        int c = 0;
        Map<String, Integer> numCountMap = new HashMap<>();
        for (String num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            String word = nums[i];
            if (target.startsWith(word)) {
                String need = target.substring(word.length());
                c += numCountMap.getOrDefault(need, 0);
                if (word.equals(need)) {
                    c--;
                }
            }
        }

        return c;
    }
}
