package minimumTimeToBreakLocksI;

import java.util.List;

public class MinimumTimeToBreakLocksI {

    public void helper(List<Integer> strength, int x, int k, int mask, int time, int[] ans) {
        if (mask == (1 << strength.size()) - 1) {
            ans[0] = Math.min(ans[0], time);
            return;
        }
        for (int i = 0; i < strength.size(); i++) {
            if ((mask & (1 << i)) == 0) {
                helper(strength, x + k, k, (mask ^ (1 << i)), time + (strength.get(i) + x - 1) / x, ans);
            }
        }
    }

    public int findMinimumTime(List<Integer> strength, int k) {
        int[] ans = new int[] {Integer.MAX_VALUE};
        helper(strength, 1, k, 0, 0, ans);
        return ans[0];
    }
}
