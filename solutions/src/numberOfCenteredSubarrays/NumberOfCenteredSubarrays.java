package numberOfCenteredSubarrays;

import java.util.HashMap;
import java.util.Map;

public class NumberOfCenteredSubarrays {
    public int centeredSubarrays(int[] nums) {
        int c = 0;
        for (int size = 1; size <= nums.length; size++) {
            int sum = 0;
            int l = 0;
            Map<Integer, Integer> countMap = new HashMap<>(size * size);
            for (int r = 0; r < nums.length; r++) {
                sum += nums[r];
                countMap.put(nums[r], countMap.getOrDefault(nums[r], 0) + 1);
                if (r - l + 1 > size) {
                    countMap.put(nums[l], countMap.get(nums[l]) - 1);
                    sum -= nums[l];
                    l++;
                }
                if (r - l + 1 == size) {
                    if (countMap.getOrDefault(sum, 0) > 0) {
                        c++;
                    }
                }
            }
        }
        return c;
    }
}
