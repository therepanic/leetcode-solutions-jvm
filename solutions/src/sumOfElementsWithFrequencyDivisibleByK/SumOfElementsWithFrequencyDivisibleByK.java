package sumOfElementsWithFrequencyDivisibleByK;

import java.util.HashMap;
import java.util.Map;

public class SumOfElementsWithFrequencyDivisibleByK {
    public int sumDivisibleByK(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int v : nums) {
            sumMap.put(v, sumMap.getOrDefault(v, 0) + 1);
        }
        int sum = 0;
        for (var entry : sumMap.entrySet()) {
            if (entry.getValue() % k == 0) {
                sum += entry.getKey() * entry.getValue();
            }
        }
        return sum;
    }
}
