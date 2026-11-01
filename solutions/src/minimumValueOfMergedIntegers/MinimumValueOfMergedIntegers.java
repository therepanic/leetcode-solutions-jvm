package minimumValueOfMergedIntegers;

public class MinimumValueOfMergedIntegers {
    public int minMergedInteger(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i += 2) {
            int a = nums[i];

            int b = nums[i + 1];
            int c = 0;
            int d = b;
            while (b != 0) {
                c *= 10;
                c += b % 10;
                b /= 10;
            }
            while (d != 0) {
                a *= 10;
                a += c % 10;
                c /= 10;
                d /= 10;
            }
            ans = Math.min(ans, a);
        }
        return ans;
    }
}
