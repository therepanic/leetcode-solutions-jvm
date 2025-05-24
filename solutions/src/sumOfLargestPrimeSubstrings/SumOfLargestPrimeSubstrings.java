package sumOfLargestPrimeSubstrings;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SumOfLargestPrimeSubstrings {
    public static long sumOfLargestPrimes(String s) {
        PriorityQueue<Long> heap = new PriorityQueue<>(Comparator.reverseOrder());
        bypass(s.toCharArray(), 0, "", heap, new HashSet<>());
        long sum = 0;
        for (int i = 0; i < 3 && !heap.isEmpty(); i++) {
            sum += heap.poll();
        }
        return sum;
    }

    public static void bypass(char[] chars, int it, String str, PriorityQueue<Long> answer, Set<String> nums) {
        if (!nums.contains(str) && !str.isEmpty() && isPrime(Long.parseLong(str))) {
            answer.add(Long.parseLong(str));
            nums.add(str);
        }
        if (it < chars.length) {
            if (!(str + chars[it]).equals("0")) {
                bypass(chars, it + 1, str + chars[it], answer, nums);
            }
            bypass(chars, it + 1, "", answer, nums);
        }
    }

    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
