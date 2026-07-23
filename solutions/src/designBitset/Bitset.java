package designBitset;

public class Bitset {

    private final long[] bits;

    private final int size;

    private boolean flipped;
    private int ones;

    public Bitset(int size) {
        this.bits = new long[(size / 64) + 1];
        this.size = size;
    }

    public void fix(int idx) {
        int word = idx / 64;
        int bit = idx % 64;
        long mask = 1L << bit;
        boolean physicalBit = (this.bits[word] & mask) != 0;
        boolean actualBit = physicalBit ^ this.flipped;
        if (!actualBit) {
            if (!this.flipped) {
                this.bits[word] |= mask;
                this.ones++;
            } else {
                this.bits[word] &= ~mask;
                this.ones--;
            }
        }
    }

    public void unfix(int idx) {
        int word = idx / 64;
        int bit = idx % 64;
        long mask = 1L << bit;
        boolean physicalBit = (this.bits[word] & mask) != 0;
        boolean actualBit = physicalBit ^ this.flipped;
        if (actualBit) {
            if (!this.flipped) {
                this.bits[word] &= ~mask;
                this.ones--;
            } else {
                this.bits[word] |= mask;
                this.ones++;
            }
        }
    }

    public void flip() {
        this.flipped = !this.flipped;
    }

    public boolean all() {
        return !this.flipped ? this.ones == this.size : (this.size - this.ones) == this.size;
    }

    public boolean one() {
        return !this.flipped ? this.ones > 0 : (this.size - this.ones) > 0;
    }

    public int count() {
        return !this.flipped ? this.ones : this.size - this.ones;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.bits.length; i++) {
            for (int j = 0; j < 64 && j + (i * 64) < this.size; j++) {
                int b = (this.bits[i] & (1L << j)) != 0 ? 1 : 0;
                str.append(!this.flipped ? b : Math.abs(b - 1));
            }
        }
        return str.toString();
    }
}

