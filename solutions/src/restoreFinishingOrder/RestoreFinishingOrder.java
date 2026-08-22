package restoreFinishingOrder;

import java.util.HashSet;
import java.util.Set;

public class RestoreFinishingOrder {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> set = new HashSet<>();
        for (int v : friends) {
            set.add(v);
        }
        int[] ans = new int[friends.length];
        int it = 0;
        for (int i = 0; i < order.length; i++) {
            if (set.contains(order[i])) {
                ans[it] = order[i];
                it++;
            }
        }
        return ans;
    }
}
