package numberOfSubArraysWithOddSum;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArraysWithOddSum {
    public static int numOfSubarrays(int[] arr) {
        Map<Integer, Integer> checked = new HashMap<>(Map.of(0, 1));
        long all = ((long) arr.length * (arr.length + 1)) / 2;
        long c = 0;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            int sumDiv = sum % 2;
            if (sumDiv < 0) {
                sumDiv += 2;
            }
            if (checked.containsKey(sumDiv)) {
                c += checked.get(sumDiv);
                checked.put(sumDiv, checked.get(sumDiv) + 1);
            } else {
                checked.put(sumDiv, 1);
            }
        }
        return (int) ((all - c) % (1e9 + 7));
    }
}
