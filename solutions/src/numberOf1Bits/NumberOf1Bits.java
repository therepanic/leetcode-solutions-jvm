package numberOf1Bits;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int c = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                c++;
            }
        }
        return c;
    }
}
