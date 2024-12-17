package removeCoveredIntervals;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int result = Integer.compare(a[0], b[0]);

            if (result == 0) {
                return Integer.compare(b[1], a[1]);
            } else {
                return result;
            }
        });

        int[] last = null;
        int count = 0;

        for (int[] interval : intervals) {
            if (last == null) {
                last = interval;
            } else if (interval[0] >= last[0] && interval[1] <= last[1]) {
                count++;
            } else {
                last = interval;
            }
        }

        return intervals.length - count;
    }
}
