package hammingDistance;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int a = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & (1 << i)) != (y & (1 << i))) {
                a++;
            }
        }
        return a;
    }
}
