package primeSubtractionOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSubtractionOperation {
    public static boolean primeSubOperation(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
        }
        boolean[] primes = getPrime(max);
        List<Integer> primeNums = new ArrayList<>();
        for (int i = 1; i < primes.length; i++) {
            if (primes[i]) {
                primeNums.add(i);
            }
        }
        int b = nums[0];
        nums[0] = check(primeNums, nums[0], -1);
        if (nums[0] == -1) {
            nums[0] = b;
        }
        for (int i = 1; i < nums.length; i++) {
            int buff = nums[i];
            nums[i] = check(primeNums, nums[i], nums[i - 1]);
           if (nums[i] == -1) {
               nums[i] = buff;
           }
            if (nums[i - 1] >= nums[i]) return false;
        }
        return true;
    }

    public static int check(List<Integer> primeNums, int num, int prev) {
        for (int i = primeNums.size() - 1; i >= 0; i--) {
            int prime = primeNums.get(i);
            if (prime < num && num - prime > prev) {
                return num - prime;
            }
        }
        return -1;
    }

    public static boolean[] getPrime(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
