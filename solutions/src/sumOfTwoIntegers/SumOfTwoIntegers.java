package sumOfTwoIntegers;

public class SumOfTwoIntegers {

    public static int getSum(int a, int b) {
        int d = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            int g = d ^ carry;
            int h = (d & carry) << 1;
            d = g;
            carry = h;
        }
        return d;
    }
}
