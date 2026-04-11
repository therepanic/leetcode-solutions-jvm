package minimumOperationsToTransformArrayIntoAlternatingPrime;

public class MinimumOperationsToTransformArrayIntoAlternatingPrime {
    public int minOperations(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int v : nums) {
            max = Math.max(v, max);
        }
        int c = 0;
        int[] primes = getPrimes(max + 100);
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (i % 2 == 0) {
                int a = ceilPrime(primes, v);
                c += a - v;
            } else {
                while (isPrime(v, primes)) {
                    v++;
                    c++;
                }
            }
        }
        return c;
    }

    private boolean isPrime(int v, int[] primes) {
        int left = 0, right = primes.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (primes[mid] == v) return true;
            if (primes[mid] < v) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static int[] getPrimes(int n) {
        if (n < 2) return new int[0];

        boolean[] isPrime = new boolean[n + 1];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) count++;
        }

        int[] primes = new int[count];
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes[index++] = i;
        }

        return primes;
    }

    public int ceilPrime(int[] primes, int target) {
        int left = 0, right = primes.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (primes[mid] >= target) {
                result = primes[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
