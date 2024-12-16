package nonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int[] last = null;
        int count = 0;

        for (int[] interval : intervals) {
            if (last == null || (interval[0] >= last[1])) {
                last = interval;
            } else {
                count++;
            }
        }

        return count;
    }
}
