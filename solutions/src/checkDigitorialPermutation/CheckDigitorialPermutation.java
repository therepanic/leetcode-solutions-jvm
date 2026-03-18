package checkDigitorialPermutation;

public class CheckDigitorialPermutation {
    public boolean isDigitorialPermutation(int n) {
        int sum = 0;
        int c = n;
        while (c > 0) {
            sum += fac(c % 10);
            c /= 10;
        }
        return check(sum, n);
    }

    public boolean check(int a, int b) {
        int[] arr = new int[10];
        while (a > 0) {
            arr[a % 10]++;
            a /= 10;
        }
        while (b > 0) {
            arr[b % 10]--;
            b /= 10;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int fac(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
}
