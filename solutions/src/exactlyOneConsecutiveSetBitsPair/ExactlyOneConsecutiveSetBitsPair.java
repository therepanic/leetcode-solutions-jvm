package exactlyOneConsecutiveSetBitsPair;

public class ExactlyOneConsecutiveSetBitsPair {
    public boolean consecutiveSetBits(int n) {
        int pair = 0;
        for (int i = 1; i < 32; i++) {
            if ((n & (1 << i)) != 0 && (n & (1 << (i - 1))) != 0) {
                if (pair > 0) {
                    return false;
                }
                pair++;
            }

        }
        return pair == 1;
    }
}
