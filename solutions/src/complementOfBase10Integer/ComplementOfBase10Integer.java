package complementOfBase10Integer;

public class ComplementOfBase10Integer {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int c = 0;
        int pos = 0;
        while (n != 0) {
            int b = (n & 1) ^ 1;
            n >>= 1;
            c |= b << pos;
            pos++;
        }
        return c;
    }
}
