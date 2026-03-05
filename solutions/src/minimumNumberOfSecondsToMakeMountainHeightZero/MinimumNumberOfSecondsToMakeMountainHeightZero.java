package minimumNumberOfSecondsToMakeMountainHeightZero;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNumberOfSecondsToMakeMountainHeightZero {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<long[]> heap =   new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        for (int i = 0; i < workerTimes.length; i++) {
            heap.add(new long[] {workerTimes[i], workerTimes[i], 1});
        }
        long min = 0;
        while (mountainHeight > 0) {
            long[] poll = heap.poll();
            min = poll[0];
            mountainHeight--;
            heap.add(new long[]{poll[0] + poll[1] * (poll[2] + 1), poll[1], poll[2] + 1});
        }
        return min;
    }
}
