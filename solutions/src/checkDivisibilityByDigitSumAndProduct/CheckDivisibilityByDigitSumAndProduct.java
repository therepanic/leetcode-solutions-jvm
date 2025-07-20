package checkDivisibilityByDigitSumAndProduct;

public class CheckDivisibilityByDigitSumAndProduct {
    public boolean checkDivisibility(int n) {
        int nCopy = n;
        int sum = 0;
        int product = -1;
        while (nCopy > 0) {
            int digit = nCopy % 10;
            if (product == -1) {
                product = digit;
            } else {
                product *= digit;
            }
            sum += digit;
            nCopy /= 10;
        }
        return n % (sum + product) == 0;
    }
}
