package longestSquareStreakInAnArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSquareStreakInAnArray {
    public static int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Double, Integer> countMap = new HashMap<>();
        int maxVal = 1;
        for (int i = 0; i < nums.length; i++) {
            double num = nums[i];
            double sqrtVal = Math.sqrt(num);
            if ((!countMap.containsKey(num)) || (countMap.containsKey(num) && countMap.containsKey(sqrtVal))) {
                int val = countMap.getOrDefault(sqrtVal, 0) + 1;
                countMap.put(num, val);
                maxVal = Math.max(maxVal, val);
            }
        }
        return maxVal == 1 ? -1 : maxVal;
    }
}
