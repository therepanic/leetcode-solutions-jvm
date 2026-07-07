package concatenateNonZeroDigitsAndMultiplyBySumI;

public class ConcatenateNonZeroDigitsAndMultiplyBySumI {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        long pos = 1;
        while (n != 0) {
            int v = n % 10;
            n /= 10;
            if (v != 0) {
                sum += v;
                x = v * pos + x;
                pos *= 10;
            }
        }
        return x * sum;
    }
}
