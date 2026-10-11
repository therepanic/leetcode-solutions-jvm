package threeFibonacciSum;

public class ThreeFibonacciSum {
    public boolean threeFibonacciSum(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        while (a + b + c<= n) {
            if (a + b + c == n) {
                return true;
            }
            int d = b;
            b += a;
            a = d;
            c = a + b;
        }
        return false;
    }
}
