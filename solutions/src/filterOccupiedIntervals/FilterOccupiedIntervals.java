package filterOccupiedIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterOccupiedIntervals {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        Arrays.sort(occupiedIntervals, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            } else {
                return Integer.compare(p1[0], p2[0]);
            }
        });
        List<List<Integer>> intervals = new ArrayList<>();
        int[] last = occupiedIntervals[0];
        for (int i = 1; i < occupiedIntervals.length; i++) {
            if (occupiedIntervals[i][0] <= last[1] || occupiedIntervals[i][0] <= last[1] + 1) {
                last[1] = Math.max(last[1], occupiedIntervals[i][1]);
            } else {
                intervals.add(List.of(last[0], last[1]));
                last = occupiedIntervals[i];
            }
        }
        intervals.add(List.of(last[0], last[1]));
        List<List<Integer>> styled = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            List<Integer> interval = intervals.get(i);
            if (interval.getFirst() >= freeStart && interval.getLast() <= freeEnd) {
                continue;
            } else if (interval.getFirst() < freeStart && interval.getLast() >= freeStart && interval.getLast() <= freeEnd) {
                styled.add(List.of(interval.getFirst(), freeStart - 1));
            } else if (interval.getFirst() >= freeStart && interval.getFirst() <= freeEnd && interval.getLast() > freeEnd) {
                styled.add(List.of(freeEnd + 1, interval.getLast()));
            } else if (interval.getFirst() < freeStart && interval.getLast() > freeEnd) {
                styled.add(List.of(interval.getFirst(), freeStart - 1));
                styled.add(List.of(freeEnd + 1, interval.getLast()));
            } else if (interval.getLast() < freeStart || interval.getFirst() > freeEnd) {
                styled.add(interval);
            }
        }
        return styled;
    }
}
