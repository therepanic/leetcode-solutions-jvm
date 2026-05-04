package sumOfPrimesBetweenNumberAndItsReverse;

import java.util.Arrays;

public class SumOfPrimesBetweenNumberAndItsReverse {
    public int sumOfPrimesInRange(int n) {
        int m = reverse(n);
        int lo = Math.min(n, m);
        int hi = Math.max(n, m);
        boolean[] primes = getPrimes(hi);
        int s = 0;
        for (int i = lo; i <= hi; i++) {
            if (primes[i]) {
                s += i;
            }
        }
        return s;
    }

    public int reverse(int v) {
        int a = 0;
        while (v != 0) {
            a *= 10;
            a += v % 10;
            v /= 10;
        }
        return a;
    }

    public static boolean[] getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        return isPrime;
    }
}
