package smallestIntegerDivisibleByK;

public class SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        int val = 0;
        for (int i = 1; i <= k; i++) {
            val = (val * 10 + 1) % k;
            if (val == 0) {
                return i;
            }
        }
        return -1;
    }
}
