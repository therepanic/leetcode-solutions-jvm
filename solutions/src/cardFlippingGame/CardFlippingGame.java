package cardFlippingGame;

import java.util.HashSet;
import java.util.Set;

public class CardFlippingGame {
    public int flipgame(int[] fronts, int[] backs) {
        int n = fronts.length;
        Set<Integer> blacklist = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                blacklist.add(fronts[i]);
            }
        }
        int pos = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (fronts[i] != backs[i]) {
                if (!blacklist.contains(fronts[i])) {
                    pos = Math.min(pos, fronts[i]);
                }
                if (!blacklist.contains(backs[i])) {
                    pos = Math.min(pos, backs[i]);
                }
            }
        }
        return pos == Integer.MAX_VALUE ? 0 : pos;
    }
}
