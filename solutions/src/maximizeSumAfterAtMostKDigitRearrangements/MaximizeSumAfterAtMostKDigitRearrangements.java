package maximizeSumAfterAtMostKDigitRearrangements;

import java.util.*;

public class MaximizeSumAfterAtMostKDigitRearrangements {
    public long maximizeSum(int[] nums, int k) {
        List<long[]> big = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            List<Integer> numbers = new ArrayList<>();
            while (v != 0) {
                numbers.add(v % 10);
                v /= 10;
            }
            Collections.sort(numbers);
            long a = 0;
            for (int j = numbers.size() - 1; j >= 0; j--) {
                a *= 10;
                a += numbers.get(j);
            }
            if (a != nums[i]) {
                big.add(new long[] {a, i});
            }
        }
        big.sort(Comparator.comparingLong(p -> p[0] - nums[(int) p[1]]));
        long ans = 0;
        boolean[] checked = new boolean[nums.length];
        for (int i = big.size() - 1; i >= 0 && k != 0; i--, k--) {
            ans += big.get(i)[0];
            checked[(int) big.get(i)[1]] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!checked[i]) {
                ans += nums[i];
            }
        }
        return ans;
    }
}
