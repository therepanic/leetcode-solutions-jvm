package maximizeYSumByPickingATripletOfDistinctXValues;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximizeYSumByPickingATripletOfDistinctXValues {

    public static int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer, Integer> indexValMap = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            int val = indexValMap.getOrDefault(x[i], 0);
            indexValMap.put(x[i], Math.max(val, y[i]));
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        heap.addAll(indexValMap.values());
        if (heap.size() < 3) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += heap.poll();
        }
        return sum;
    }

}
