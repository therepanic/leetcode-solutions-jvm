package maximumAveragePassRatio;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingDouble(a -> (double) a[0] / a[1] - (double) (a[0] + 1) / (a[1] + 1)));

        heap.addAll(Arrays.asList(classes));

        while (extraStudents > 0) {
            int[] poll = heap.poll();
            poll[0]++;
            poll[1]++;

            heap.add(poll);
            extraStudents--;
        }

        double sum = 0;

        while (!heap.isEmpty()) {
            int[] poll = heap.poll();

            sum += (double) poll[0] / poll[1];
        }

        return sum / classes.length;
    }
}
