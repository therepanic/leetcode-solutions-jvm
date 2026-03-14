package minimumCostToEqualizeArraysUsingSwaps;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostToEqualizeArraysUsingSwaps {
    public int minCost(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            freq.put(nums1[i], freq.getOrDefault(nums1[i], 0) + 1);
            freq.put(nums2[i], freq.getOrDefault(nums2[i], 0) + 1);
        }
        for (var entry : freq.entrySet())  {
            if (entry.getValue() % 2 != 0) {
                return -1;
            }
        }
        Map<Integer, Integer> first = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            first.put(nums1[i], first.getOrDefault(nums1[i], 0) + 1);
        }
        int ans = 0;
        for (var entry : first.entrySet()) {
            int a = entry.getValue() - freq.get(entry.getKey()) / 2;
            if (a > 0) {
                ans += a;
            }
        }
        return ans;
    }
}
