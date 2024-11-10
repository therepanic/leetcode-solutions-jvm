package maxSumOfAPairWithEqualSumOfDigits;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxSumOfAPairWithEqualSumOfDigits {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int sum = sumOfDigits(num);

            if (cache.containsKey(sum)) {
                maxSum = Math.max(maxSum, num + cache.get(sum));

                cache.put(sum, Math.max(num, cache.get(sum)));
            } else {
                cache.put(sum, num);
            }
        }

        return 0;
    }

    private int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
