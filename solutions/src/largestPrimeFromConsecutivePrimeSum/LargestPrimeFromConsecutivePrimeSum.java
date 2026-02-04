package largestPrimeFromConsecutivePrimeSum;

import java.util.Arrays;

public class LargestPrimeFromConsecutivePrimeSum {
    public int largestPrime(int n) {
        boolean[] primes = sieve(n);
        int max = 0;
        int sum = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                sum += i;
                if (sum >= primes.length) {
                    break;
                }
                if (primes[sum]) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        if (n >= 2) {
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;
            for (int i = 2; (long) i * i <= n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return isPrime;
    }
}
