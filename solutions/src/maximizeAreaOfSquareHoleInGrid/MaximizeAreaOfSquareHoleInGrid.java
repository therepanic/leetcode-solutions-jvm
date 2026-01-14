package maximizeAreaOfSquareHoleInGrid;

import java.util.Arrays;

public class MaximizeAreaOfSquareHoleInGrid {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int hc = 1;
        int hMaxVal = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) {
                hc++;
            } else {
                hc = 1;
            }
            hMaxVal = Math.max(hMaxVal, hc);
        }
        int vc = 1;
        int vMaxVal = 1;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) {
                vc++;
            } else {
                vc = 1;
            }
            vMaxVal = Math.max(vMaxVal, vc);
        }
        int size = Math.min(hMaxVal, vMaxVal) + 1;
        return size * size;
    }
}
