package reduceArraySizeToTheHalf;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToTheHalf {
    public static int minSetSize(int[] arr) {
        Map<Integer, Integer> valCountMap = new HashMap<>();

        for (int val : arr) {
            if (valCountMap.containsKey(val)) {
                valCountMap.put(val, valCountMap.get(val) + 1);
            } else {
                valCountMap.put(val, 1);
            }
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int val : valCountMap.values()) {
            heap.add(val);
        }

        int size = arr.length;
        int c = 0;

        while (size * 2 > arr.length && !heap.isEmpty()) {
            size -= heap.poll();
            c++;
        }

        return c;
    }
}
