package divideArrayInSetsOfKConsecutiveNumbers;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class DivideArrayInSetsOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;

        Map<Integer, Integer> numCountMap = new TreeMap<>();

        for (int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        for (int num : numCountMap.keySet()) {
            int count = numCountMap.get(num);
            if (count > 0) {
                for (int i = 0; i < k; i++) {
                    int nextNum = num + i;
                    int nextCount = numCountMap.getOrDefault(nextNum, 0);
                    if (nextCount < count) {
                        return false;
                    }
                    numCountMap.put(nextNum, nextCount - count);
                }
            }
        }

        return true;
    }
}
