package maximumNumberOfEatenApples;

import java.util.*;

public class MaximumNumberOfEatenApples {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        Map<Integer, Integer> dayMap = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int c = 0;
        for (int i = 0; i < n || !heap.isEmpty(); i++) {
            if (i < n && apples[i] > 0) {
                heap.add(days[i] + i);
                dayMap.put(days[i] + i, dayMap.getOrDefault(days[i] + i, 0) + apples[i]);
            }
            while (!heap.isEmpty() && i >= heap.peek()) {
                heap.poll();
            }
            if (!heap.isEmpty()) {
                int peek = heap.peek();
                dayMap.put(peek, dayMap.get(peek) - 1);
                c++;
                if (dayMap.get(peek) == 0) {
                    heap.poll();
                }
            }
        }
        return c;
    }
}
