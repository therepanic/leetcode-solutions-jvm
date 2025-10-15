package sumOfDistances;

import java.util.HashMap;
import java.util.Map;

public class SumOfDistances {
    public long[] distance(int[] nums) {
        Map<Integer, Long> count = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();
        long[] all = new long[nums.length];
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            all[i] += count.getOrDefault(nums[i], 0L) * c - sum.getOrDefault(nums[i], 0L);
            sum.put(nums[i], sum.getOrDefault(nums[i], 0L) + c);
            count.put(nums[i], count.getOrDefault(nums[i], 0L) + 1);
            c++;
        }
        count.clear();
        sum.clear();
        c = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            all[i] += count.getOrDefault(nums[i], 0L) * c - sum.getOrDefault(nums[i], 0L);
            sum.put(nums[i], sum.getOrDefault(nums[i], 0L) + c);
            count.put(nums[i], count.getOrDefault(nums[i], 0L) + 1);
            c++;
        }
        return all;
    }
}
