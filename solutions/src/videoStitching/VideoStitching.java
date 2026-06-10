package videoStitching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoStitching {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            } else {
                return Integer.compare(p1[0], p2[0]);
            }
        });
        List<int[]> intervals = new ArrayList<>();
        for (int i = 1; i < clips.length; i++) {
            if (clips[i][0] != clips[i - 1][0]) {
                intervals.add(clips[i - 1]);
            }
        }
        intervals.add(clips[clips.length - 1]);
        int c = 1;
        int[] last = intervals.get(0);
        int[] pred = null;
        if (last[0] > 0) return -1;
        if (last[1] >= time) return 1;
        int lastP = Integer.MIN_VALUE;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i)[0] <= last[1]) {
                int d = intervals.get(i)[1] - last[1];
                if (d > lastP) {
                    lastP = d;
                    pred = intervals.get(i);
                    if (pred[1] >= time) {
                        return c + 1;
                    }
                }
            } else {
                if (pred != null) {
                    i--;
                    last = pred;
                    lastP = -1;
                    pred = null;
                    c++;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }
}
