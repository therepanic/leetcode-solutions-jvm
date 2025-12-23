package twoBestNonOverlappingEvents;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TwoBestNonOverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        PriorityQueue<Pair<Integer, Integer>> heap =
                new PriorityQueue<>(Comparator.comparingInt(p -> p.first));
        Arrays.sort(events, Comparator.comparingInt(p -> p[0]));
        int maxSum = 0;
        int maxVal = 0;
        for (int i = 0; i < events.length; i++) {
            while (!heap.isEmpty() && heap.peek().first < events[i][0]) {
                maxVal = Math.max(maxVal, heap.poll().second);
            }
            heap.add(new Pair<>(events[i][1], events[i][2]));
            maxSum = Math.max(maxSum, events[i][2] + maxVal);
        }
        return maxSum;
    }

    private static class Pair<T, E> {
        public T first;
        public E second;

        public Pair(T first, E second) {
            this.first = first;
            this.second = second;
        }
    }
}
