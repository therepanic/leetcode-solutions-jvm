package minimumCostOfBuyingCandiesWithDiscount;

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        boolean ok = false;
        for (int r = cost.length - 1; r >= 0; r--) {
            sum += cost[r];
            if (!ok) {
                ok = true;
            } else {
                r--;
                ok = false;
            }
        }
        return sum;
    }
}
