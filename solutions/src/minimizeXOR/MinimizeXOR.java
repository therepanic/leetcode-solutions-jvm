package minimizeXOR;

public class MinimizeXOR {
    public int minimizeXor(int num1, int num2) {
        int setBits = 0;
        for (int i = 0; i < 32; i++) {
            setBits += ((num2 & (1 << i)) != 0) ? 1 : 0;
        }
        int x = 0;
        for (int i = 31; i >= 0 && setBits != 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                x |= (1 << i);
                setBits--;
            }
        }
        for (int i = 0; i < 32 && setBits != 0; i++) {
            if ((x & (1 << i)) == 0) {
                x |= (1 << i);
                setBits--;
            }
        }
        return x;
    }
}
