package closestPrimeNumbersInRange;

import java.util.Arrays;

public class ClosestPrimeNumbersInRange {
    public static int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int[] pair = new int[] {-1, -1};
        int minDiff = Integer.MAX_VALUE;
        Integer lastOk = null;
        for (int i = left; i <= right; i++) {
            if (!isPrime[i]) continue;
            if (lastOk != null) {
                int diff = i - lastOk;
                if (diff < minDiff) {
                    minDiff = diff;
                    pair[0] = lastOk;
                    pair[1] = i;
                }
            }
            lastOk = i;
        }
        return pair;
    }
}
