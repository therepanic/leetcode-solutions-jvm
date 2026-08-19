package cinemaSeatAllocation;

import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rows = new HashMap<>();
        for (int[] v : reservedSeats) {
            rows.put(v[0], rows.getOrDefault(v[0], 0) | (1 << v[1]));
        }
        int ans = 2 * n - (rows.size() * 2);
        for (int v : rows.values()) {
            ans = getAns(v, ans);
        }
        return ans;
    }

    private int getAns(int c, int ans) {
        boolean[] a = new boolean[3];
        for (int it = 1; it <= 3; it++) {
            boolean ok = true;
            int s = 2 * it;
            for (int i = s; i <= 3 + s; i++) {
                if ((c & (1 << i)) != 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                a[it - 1] = true;
            }
        }
        if (a[0] && a[2]) {
            ans += 2;
        } else if (a[0] || a[1] || a[2]) {
            ans++;
        }
        return ans;
    }
}
