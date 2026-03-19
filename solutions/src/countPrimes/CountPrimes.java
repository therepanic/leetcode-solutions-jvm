package countPrimes;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] sieve = sieve(n);
        int c = 0;
        for (int i = 2; i < n; i++) {
            if (sieve[i]) {
                c++;
            }
        }
        return c;
    }

    public static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        if (n < 2) return isPrime;

        for (int i = 2; i <= n; i++) isPrime[i] = true;

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
