package smallestValueAfterReplacingWithSumOfPrimeFactors;

public class SmallestValueAfterReplacingWithSumOfPrimeFactors {
    public int smallestValue(int n) {
        int ans = n;
        while (true) {
            int sum = 0;
            int a = 2;
            while (n != 1) {
                if (n % a != 0) {
                    a++;
                } else {
                    n /= a;
                    sum += a;
                }
            }
            n = sum;
            if (sum == ans) {
                break;
            } else {
                ans = sum;
            }
        }
        return ans;
    }
}
