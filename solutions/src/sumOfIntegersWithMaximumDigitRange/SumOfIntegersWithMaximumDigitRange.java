package sumOfIntegersWithMaximumDigitRange;

public class SumOfIntegersWithMaximumDigitRange {
    public int maxDigitRange(int[] nums) {
        int maxW = 0;
        int sum = 0;
        for (int b : nums) {
            int v = b;
            int large = Integer.MIN_VALUE;
            int small = Integer.MAX_VALUE;
            while (v != 0) {
                int a = v % 10;
                v /= 10;
                large = Math.max(large, a);
                small = Math.min(small, a);
            }
            int diff = large - small;
            if (diff > maxW) {
                maxW = diff;
                sum = b;
            } else if (diff >= maxW) {
                sum += b;
            }
        }
        return sum;
    }
}
