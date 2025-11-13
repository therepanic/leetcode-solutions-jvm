package maximizeActiveSectionWithTradeI;

import java.util.HashMap;
import java.util.Map;

public class MaximizeActiveSectionWithTradeI {
    public int maxActiveSectionsAfterTrade(String s) {
        char[] sChars = s.toCharArray();
        int l = 0;
        Map<Integer, Integer> valMap = new HashMap<>();
        int active = 0;
        int[] ind = new int[sChars.length];
        int ans = 0;
        for (int r = 0; r < sChars.length; r++) {
            if (sChars[r] == '1') {
                active++;
                valMap.put(l, r - l);
                l = r + 1;
                continue;
            }
            ind[r] = l;
        }
        valMap.put(l, sChars.length - l);
        l = 0;
        for (int r = 0; r < sChars.length; r++) {
            if (sChars[r] == '0') {
                if (r != 0 && sChars[r - 1] == '1') {
                    int c = 0;
                    c += valMap.get(ind[r]);
                    if (l - 1 >= 0) {
                        c += valMap.getOrDefault(ind[l - 1], 0);
                    }
                    c -= r - l + 1;
                    c += active;
                    ans = Math.max(ans, c);

                }
                l = r + 1;
            }
        }
        return ans;
    }
}
