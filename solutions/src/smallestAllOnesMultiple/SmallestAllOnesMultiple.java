package smallestAllOnesMultiple;

public class SmallestAllOnesMultiple {
    public int minAllOneMultiple(int k) {
        int a = 0;
        for (int i = 1; i <= k; i++) {
            a = (a * 10 + 1) % k;
            if (a == 0) {
                return i;
            }
        }
        return -1;
    }
}
