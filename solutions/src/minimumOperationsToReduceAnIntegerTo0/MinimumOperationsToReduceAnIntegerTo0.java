package minimumOperationsToReduceAnIntegerTo0;

public class MinimumOperationsToReduceAnIntegerTo0 {
    public int minOperations(int n) {
        int ops = 0;
        for (int i = 0; i < 32; i++) {
            boolean a = (n & (1 << i)) != 0;
            boolean b = (n & (1 << (i + 1))) != 0;
            if (a && b) {
                n += 1 << i;
                ops++;
            } else if (a) {
                n -= 1 << i;
                ops++;
            }
        }
        if ((n & 1) != 0) {
            ops++;
        }
        return ops;
    }
}
