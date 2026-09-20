package numberOfIntersectingIntervalPairsI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfIntersectingIntervalPairsI {
    public int countIntersectingIntervals(int[][] intervals) {
        long c = 0;
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            start.add(intervals[i][0]);
            end.add(intervals[i][1]);
        }
        Collections.sort(start);
        Collections.sort(end);
        int j = 0;
        int ans = 0;
        for (int i = 0; i < start.size(); i++) {
            while (j < end.size() && start.get(i) > end.get(j)) {
                j++;
            }
            ans += i - j;
        }
        return ans;
    }
}
