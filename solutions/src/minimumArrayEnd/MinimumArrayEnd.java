package minimumArrayEnd;

public class MinimumArrayEnd {
    public long minEnd(int n, int x) {
        long remain = n - 1;
        long result = x;
        long pos = 1;
        while (remain != 0) {
            if ((x & pos) == 0) {
                result |= (remain & 1) * pos;
                remain >>= 1;
            }
            pos <<= 1;
        }
        return result;
    }
}
