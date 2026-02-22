package binaryGap;

public class BinaryGap {
    public int binaryGap(int n) {
        String bits = Integer.toBinaryString(n);
        int it = -1;
        int maxGap = 0;
        for (int i = 0; i < bits.length(); i++) {
            boolean one = bits.charAt(i) == '1';
            if (one && it == -1) {
                it = i;
            } else if (one) {
                maxGap = Math.max(maxGap, i - it);
                it = i;
            }
        }
        return maxGap;
    }
}
