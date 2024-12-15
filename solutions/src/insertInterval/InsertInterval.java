package insertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        boolean isChanged = false;

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (newInterval[1] > interval[1] && newInterval[0] <= interval[1]) {
                interval[0] = Math.min(interval[0], newInterval[0]);
                interval[1] = newInterval[1];

                isChanged = true;
                break;
            }
        }

        if (!isChanged) {
            int[][] newIntervals = new int[intervals.length + 1][];
            for (int i = 0; i < intervals.length; i++) {
                newIntervals[i] = intervals[i];
            }
            newIntervals[newIntervals.length - 1] = newInterval;

            return merge(newIntervals);
        }

        return merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(p -> p[0]));

        List<int[]> intervalsList = new ArrayList<>(Arrays.asList(intervals));
        for (int i = 1; i < intervalsList.size(); i++) {
            int[] first = intervalsList.get(i);
            int[] second = intervalsList.get(i - 1);

            if (first[0] <= second[1]) {
                second[1] = Math.max(second[1], first[1]);

                intervalsList.remove(i);
                i--;
            }
        }

        return intervalsList.toArray(new int[intervalsList.size()][]);
    }
}
