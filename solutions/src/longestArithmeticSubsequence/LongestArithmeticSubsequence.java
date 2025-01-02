package longestArithmeticSubsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        int max = 1;
        Map<Integer, Integer>[] maps = new Map[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int dif = nums[i] - nums[j];

                if (maps[i] == null) {
                    maps[i] = new HashMap<>();
                }

                if (maps[j] == null) {
                    maps[j] = new HashMap<>();
                }

                maps[i].put(dif, maps[j].getOrDefault(dif, 1) + 1);

                max = Math.max(max, maps[i].get(dif));
            }
        }

        return max;
    }
}
