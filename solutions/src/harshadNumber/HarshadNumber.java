package harshadNumber;

public class HarshadNumber {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int a = x;
        int b = 0;
        while (a != 0) {
            b += a % 10;
            a /= 10;
        }
        return b % x == 0 ? b : -1;
    }
}
