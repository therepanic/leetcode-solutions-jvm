package findRightInterval;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[][] newIntervals = new int[intervals.length][];

        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i] = new int[] {intervals[i][0], intervals[i][1], i};
        }

        Arrays.sort(newIntervals, Comparator.comparingInt(p -> p[0]));

        int[] answer = new int[intervals.length];
        Arrays.fill(answer, -1);

        for (int[] interval : newIntervals) {
            int l = 0;
            int r = newIntervals.length - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                int[] curInterval = newIntervals[mid];

                if (curInterval[0] >= interval[1]) {
                    answer[interval[2]] = curInterval[2];
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return answer;
    }
}
