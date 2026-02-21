package primeNumberOfSetBitsInBinaryRepresentation;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int left, int right) {
       int c = 0;
        for (int v = left; v <= right; v++) {
            char[] values = Integer.toBinaryString(v).toCharArray();
            int set = 0;
            for (int i = 0; i < values.length; i++) {
                set += values[i] == '1' ? 1 : 0;
            }
            if (isPrime(set)) {
                c++;
            }
        }
        return c;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
