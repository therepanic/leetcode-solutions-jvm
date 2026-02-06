package maximumTotalFromOptimalActivationOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumTotalFromOptimalActivationOrder {
    public long maxTotal(int[] value, int[] limit) {
        int n = value.length;
        List<PriorityQueue<Integer>> heaps = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            heaps.add(new PriorityQueue<>());
        }
        for (int i = 0; i < n; i++) {
            int v = value[i];
            int l = limit[i];
            if (l > heaps.get(l).size()) {
                heaps.get(l).add(v);
            } else if (v > heaps.get(l).peek()) {
                heaps.get(l).poll();
                heaps.get(l).add(v);
            }
        }
        long sum = 0;
        for (var heap : heaps) {
            for (int val : heap) {
                sum += val;
            }
        }
        return sum;
    }
}
