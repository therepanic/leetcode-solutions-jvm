package sumOfCompatibleNumbersInRangeI;

public class SumOfCompatibleNumbersInRangeI {
    public int sumOfGoodIntegers(int n, int k) {
        int s = n + k;
        int sum = 0;
        while (s >= Math.max(1, n - k)) {
            if ((n & s) == 0) {
                sum += s;
            }
            s--;
        }
        return sum;
    }
}
