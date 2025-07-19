package splitArrayByPrimeIndices;

public class SplitArrayByPrimeIndices {
    public long splitArray(int[] nums) {
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (isPrime(i)) {
                sum1 += val;
            } else {
                sum2 += val;
            }
        }
        return Math.abs(sum1 - sum2);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }
}
