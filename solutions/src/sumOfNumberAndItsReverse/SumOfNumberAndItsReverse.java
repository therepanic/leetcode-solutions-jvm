package sumOfNumberAndItsReverse;

public class SumOfNumberAndItsReverse {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = num / 2; i <= num; i++) {
            int a = i;
            int b = 0;
            while (a != 0) {
                b *= 10;
                b += a % 10;
                a /= 10;
            }
            if (b + i == num) {
                return true;
            }
        }
        return false;
    }
}
