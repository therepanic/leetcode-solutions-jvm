package avoidFloodInTheCity;

import java.util.*;

public class AvoidFloodInTheCity {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> val = new HashMap<>();
        TreeSet<Integer> sortedVal = new TreeSet<>();
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                sortedVal.add(i);
            } else {
                ans[i] = -1;
                if (val.containsKey(rains[i])) {
                    Integer per = sortedVal.ceiling(val.get(rains[i]));
                    if (per == null) {
                        return new int[]{};
                    } else {
                        sortedVal.remove(per);
                        ans[per] = rains[i];
                    }
                }
                val.put(rains[i], i);
            }
        }
        return ans;
    }
}
