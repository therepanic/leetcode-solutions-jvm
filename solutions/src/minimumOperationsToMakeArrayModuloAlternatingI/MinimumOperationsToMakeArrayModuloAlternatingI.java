package minimumOperationsToMakeArrayModuloAlternatingI;

import java.util.*;

public class MinimumOperationsToMakeArrayModuloAlternatingI {
    public int minOperations(int[] nums, int k) {
        int[] evenCost = new int[k];
        int[] oddCost = new int[k];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i] % k;
            for (int target = 0; target < k; target++) {
                int diff = Math.abs(cur - target);
                int cost = Math.min(diff, k - diff);
                if (i % 2 == 0) {
                    evenCost[target] += cost;
                } else {
                    oddCost[target] += cost;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (i == j) continue;
                ans = Math.min(ans, evenCost[i] + oddCost[j]);
            }
        }
        return ans;
    }
}
