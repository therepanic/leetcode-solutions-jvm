package frequencyBalanceSubarray;

import java.util.HashMap;
import java.util.Map;

public class FrequencyBalanceSubarray {
    public int getLength(int[] nums) {
        int max = 1;
        for (int l = 0; l < nums.length; l++) {
            if (nums.length - l <= max) {
                break;
            }
            Map<Integer, Integer> valueCount = new HashMap<>();
            Map<Integer, Integer> freqCount = new HashMap<>();
            valueCount.put(nums[l], 1);
            freqCount.put(1, 1);
            for (int r = l + 1; r < nums.length; r++) {
                int oldCount = valueCount.getOrDefault(nums[r], 0);
                valueCount.put(nums[r], oldCount + 1);
                if (oldCount > 0) {
                    freqCount.compute(oldCount, (_, v) -> v == 1 ? null : v - 1);
                }
                freqCount.put(oldCount + 1, freqCount.getOrDefault(oldCount + 1, 0) + 1);
                if (valueCount.size() == 1) {
                    max = Math.max(max, r - l + 1);
                } else {
                    if (freqCount.size() == 2) {
                        int a = -1;
                        int b = - 1;
                        for (int v : freqCount.keySet()) {
                            if (a == -1) {
                                a = v;
                            } else {
                                b = v;
                            }
                        }
                        if (a * 2 == b || b * 2 == a) {
                            max = Math.max(max, r - l + 1);
                        }
                    }
                }
            }
        }
        return max;
    }
}
