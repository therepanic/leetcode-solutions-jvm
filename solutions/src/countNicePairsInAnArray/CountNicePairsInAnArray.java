package countNicePairsInAnArray;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInAnArray {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        long c = 0;
        for (int num : nums) {
            int val = num - reverse(num);
            int mapVal = countMap.getOrDefault(val, 0);
            c += mapVal;
            countMap.put(val, mapVal + 1);
        }
        return (int) ((c % (1e9 + 7)));
    }

    public int reverse(int num) {
        int reversedNumber = 0;
        while (num > 0) {
            int mod = num % 10;
            reversedNumber = reversedNumber * 10 + mod;
            num /= 10;
        }
        return reversedNumber;
    }
}
