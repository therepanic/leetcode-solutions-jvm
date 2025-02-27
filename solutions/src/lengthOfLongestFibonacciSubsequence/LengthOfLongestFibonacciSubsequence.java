package lengthOfLongestFibonacciSubsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {
    public static int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            valueIndexMap.put(arr[i], i);
        }
        Map<String, Integer> indexPairCountMap = new HashMap<>();
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int first = arr[j];
                int second = arr[i];
                int third = first + second;
                if (valueIndexMap.containsKey(third)) {
                    int c = indexPairCountMap.getOrDefault(j + "!" + i, 2) + 1;
                    max = Math.max(c, max);
                    int it = valueIndexMap.get(third);
                    indexPairCountMap.put(i + "!" + it, c);
                }
            }
        }
        return max;
    }
}
