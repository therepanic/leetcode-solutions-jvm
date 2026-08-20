package minimumCapacityBox;

public class MinimumCapacityBox {
    public int minimumIndex(int[] capacity, int itemSize) {
        int cap = Integer.MAX_VALUE;
        int in = -1;
        for (int i = 0; i < capacity.length; i++) {
            int d = capacity[i] - itemSize;
            if (d >= 0 && d < cap) {
                cap = d;
                in = i;
                if (cap == 0) {
                    return in;
                }
            }
        }
        return in;
    }
}
