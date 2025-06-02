package maximumSumOfAlmostUniqueSubarray;

import java.util.*;

public class MaximumSumOfAlmostUniqueSubarray {

    public static long maxSum(List<Integer> nums, int m, int k) {
        long sum = 0;
        int l = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        long maxSum = 0;
        for (int r = 0; r < nums.size(); r++) {
            int rVal = nums.get(r);
            sum += rVal;
            numMap.put(rVal, numMap.getOrDefault(rVal, 0) + 1);
            if (r - l + 1 > k) {
                int lVal = nums.get(l);
                sum -= lVal;
                int c = numMap.get(lVal) - 1;
                if (c == 0) {
                    numMap.remove(lVal);
                } else {
                    numMap.put(lVal, c);
                }
                l++;
            }
            if (r - l + 1 == k && numMap.size() >= m) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

}
