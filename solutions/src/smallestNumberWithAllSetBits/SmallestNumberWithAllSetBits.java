package smallestNumberWithAllSetBits;

public class SmallestNumberWithAllSetBits {
    public int smallestNumber(int n) {
        for (int i = n; i <= 1000; i++) {
            if (Integer.toBinaryString(i).indexOf('0') == -1) {
                return i;
            }
        }
        return -1;
    }
}
