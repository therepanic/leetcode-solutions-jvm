package findConsecutiveIntegersFromADataStream;

import java.util.*;

public class DataStream {

    private int notCurs;
    private final Queue<Integer> values;
    private final int needValue;
    private final int k;

    public DataStream(int value, int k) {
        this.values = new ArrayDeque<>();
        this.needValue = value;
        this.k = k;
    }

    public boolean consec(int num) {
        this.values.add(num);
        if (num != needValue) {
            notCurs++;
        }
        if (this.values.size() < this.k) {
            return false;
        } else if (values.size() > this.k){
            int val = this.values.poll();
            if (val != needValue) {
                notCurs--;
            }
        }
        return notCurs == 0;
    }

}
