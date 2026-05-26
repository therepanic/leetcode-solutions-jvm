package maximizeScoreOfNumbersInRanges;

import java.util.Arrays;

public class MaximizeScoreOfNumbersInRanges {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int r = start[start.length - 1] + d;
        int l = 0;
        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean ok = true;
            long prev = start[0];
            for (int i = 1; i < start.length; i++) {
                long s = Math.max(start[i], prev + mid);
                if (s <= start[i] + d) {
                    prev = s;
                } else {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
