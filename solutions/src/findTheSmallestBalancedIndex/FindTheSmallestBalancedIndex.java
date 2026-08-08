package findTheSmallestBalancedIndex;

public class FindTheSmallestBalancedIndex {

    public static int smallestBalancedIndex(int[] nums) {
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        long[] product = new long[nums.length];
        product[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (willMultiplyOverflow(product[i + 1], nums[i])) {
                product[i] = Long.MAX_VALUE;
                break;
            }
            product[i] = product[i + 1] * nums[i];
            if (i >= 1 && product[i] >= sum[i - 1]) {
                break;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (sum[i - 1] == (i < nums.length - 1 ? product[i + 1] : 1)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean willMultiplyOverflow(long a, long b) {
        if (a == 0 || b == 0) return false;
        if (a == Long.MIN_VALUE && b == -1) return true;
        if (b == Long.MIN_VALUE && a == -1) return true;

        if (a > 0 && b > 0) {
            return a > Long.MAX_VALUE / b;
        } else if (a < 0 && b < 0) {
            return a < Long.MAX_VALUE / b;
        } else if (a > 0 && b < 0) {
            return b < Long.MIN_VALUE / a;
        } else {
            return a < Long.MIN_VALUE / b;
        }
    }
}
