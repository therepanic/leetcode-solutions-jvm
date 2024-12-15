package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
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
