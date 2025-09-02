package degreeOfAnArray;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = -1;
        for (int num : nums) {
            int temp = freq.getOrDefault(num, 0) + 1;
            if (temp > maxFreq) {
                maxFreq = temp;
            }
            freq.put(num, temp);
        }
        int l = 0;
        int minSize = Integer.MAX_VALUE;
        Map<Integer, Integer> temp = new HashMap<>();
        for (int r = 0; r < nums.length; r++) {
            temp.put(nums[r], temp.getOrDefault(nums[r], 0) + 1);
            while (temp.get(nums[r]) == maxFreq) {
                minSize = Math.min(r - l + 1, minSize);
                temp.compute(nums[l], (key, v) -> v - 1);
                l++;
            }
        }
        return minSize;
    }
}
