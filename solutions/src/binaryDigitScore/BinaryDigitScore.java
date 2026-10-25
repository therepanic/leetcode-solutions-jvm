package binaryDigitScore;

public class BinaryDigitScore {
    public int calculateScore(int A, int B) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < 32; i++) {
            if ((A & (1 << i)) != 0) {
                a++;
            }
            if ((B & (1 << i)) != 0) {
                b++;
            }
        }
        return a >= b ? a * b : b / a;
    }
}
