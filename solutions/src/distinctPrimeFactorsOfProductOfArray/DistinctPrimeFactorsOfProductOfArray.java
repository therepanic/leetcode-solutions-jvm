package distinctPrimeFactorsOfProductOfArray;

import java.util.HashSet;
import java.util.Set;

public class DistinctPrimeFactorsOfProductOfArray {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> primes = new HashSet<>();
        for (int v : nums) {
            primes.addAll(primeFactors(v));
        }
        return primes.size();
    }

    public static Set<Integer> primeFactors(int n) {
        Set<Integer> res = new HashSet<>();
        for (int d = 2; d * d <= n; d++) {
            while (n % d == 0) {
                res.add(d);
                n /= d;
            }
        }
        if (n > 1) {
            res.add(n);
        }
        return res;
    }
}
