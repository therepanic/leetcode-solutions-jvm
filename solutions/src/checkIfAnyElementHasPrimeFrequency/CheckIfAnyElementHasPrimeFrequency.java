package checkIfAnyElementHasPrimeFrequency;

import java.util.Arrays;

public class CheckIfAnyElementHasPrimeFrequency {
    public boolean checkPrimeFrequency(int[] nums) {
        boolean[] prime = sieve(101);
        int[] c = new int[101];
        for (int v : nums) {
            c[v]++;
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i] != 0 && prime[c[i]]) {
                return true;
            }
        }
        return false;
    }

    public static boolean[] sieve(int n) {
        boolean[] a = new boolean[n + 1];
        if (n < 2) return a;
        Arrays.fill(a, true);
        a[0] = a[1] = false;
        for (int i = 4; i <= n; i += 2) a[i] = false;
        for (int i = 3; (long) i * i <= n; i += 2)
            if (a[i])
                for (long j = (long) i * i; j <= n; j += i << 1)
                    a[(int) j] = false;
        return a;
    }
}
