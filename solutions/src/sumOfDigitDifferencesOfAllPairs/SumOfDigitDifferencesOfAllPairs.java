package sumOfDigitDifferencesOfAllPairs;

import java.util.HashMap;
import java.util.Map;

public class SumOfDigitDifferencesOfAllPairs {
    public long sumDigitDifferences(int[] nums) {
        int max = 0;
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            numsStr[i] = String.valueOf(nums[i]);
        }
        int maxSize = String.valueOf(max).length();
        long answer = 0;
        long c = ((long) nums.length * (nums.length - 1)) / 2;
        for (int i = 0; i < maxSize; i++) {
            Map<Character, Integer> numMap = new HashMap<>();
            for (int j = 0; j < nums.length; j++) {
                String num = numsStr[j];
                char ch = num.charAt(i);
                numMap.put(ch, numMap.getOrDefault(ch, 0) + 1);
            }
            long sameDigitPairs = 0;
            for (int count : numMap.values()) {
                sameDigitPairs += (long) count * (count - 1) / 2;
            }
            answer += c - sameDigitPairs;
        }
        return answer;
    }
}
