package numberComplement;

public class NumberComplement {
    public int findComplement(int num) {
        if (num == 0) return 1;
        int c = 0;
        int pos = 0;
        while (num != 0) {
            int b = (num & 1) ^ 1;
            num >>= 1;
            c |= b << pos;
            pos++;
        }
        return c;
    }
}
