package RLEIterator;

public class RLEIterator {
    private final int[] encoding;
    private int i;
    private int count;
    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
    }

    public int next(int n) {
        while (i < encoding.length) {
            if (encoding[i] >= n) {
                encoding[i] -= n;
                return encoding[i + 1];
            } else {
                n -= encoding[i];
                i += 2;
            }
        }
        return -1;
    }
}
