package divideIntervalsIntoMinimumNumberOfGroups;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DivideIntervalsIntoMinimumNumberOfGroups {
    public static int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(p -> p[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!heap.isEmpty() && heap.peek() < interval[0]) {
                heap.poll();
            }
            heap.add(interval[1]);
        }
        return heap.size();
    }
}
