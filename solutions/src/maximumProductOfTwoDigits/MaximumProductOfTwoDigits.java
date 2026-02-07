package maximumProductOfTwoDigits;

public class MaximumProductOfTwoDigits {
    public int maxProduct(int n) {
        int f = -1;
        int s = -1;
        while (n != 0) {
            int v = n % 10;
            if (v > f) {
                s = f;
                f = v;
            } else if (v > s) {
                s = v;
            }
            n /= 10;
        }
        return f * s;
    }
}
