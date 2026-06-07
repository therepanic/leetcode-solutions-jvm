package minimumEnergyToMaintainBrightness;

import java.util.Arrays;

public class MinimumEnergyToMaintainBrightness {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        int l = -1;
        int r = -1;
        int need = (int) Math.ceil((double) brightness / 3);
        Arrays.sort(intervals, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            } else {
                return Integer.compare(p1[0], p2[0]);
            }
        });
        long times = 0;
        for (int[] interval : intervals) {
            if (l == -1) {
                l = interval[0];
                r = interval[1];
            } else {
                if (interval[0] <= r) {
                    r = Math.max(r, interval[1]);
                } else {
                    int time = r - l + 1;
                    times += time;
                    l = interval[0];
                    r = interval[1];
                }
            }
        }
        times += r - l + 1;
        return need * times;
    }
}
