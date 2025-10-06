package minimumTimeToActivateString;

import java.util.TreeSet;

public class MinimumTimeToActivateString {
    public int minTime(String s, int[] order, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(-1);
        set.add(s.length());
        for (int i = 0; i < order.length; i++) {
            int o = order[i];
            int l = set.ceiling(o);
            int r = set.floor(o);
            k -= (long) (o - l) * (r - o);
            set.add(o);
            if (k <= 0) {
                return i;
            }
        }
        return -1;
    }
}
