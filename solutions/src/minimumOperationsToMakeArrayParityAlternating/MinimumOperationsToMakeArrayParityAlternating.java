package minimumOperationsToMakeArrayParityAlternating;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumOperationsToMakeArrayParityAlternating {
    public int[] makeParityAlternating(int[] nums) {
        int evenSt = 0;
        int oddSt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != Math.floorMod(nums[i], 2)) {
                evenSt++;
            }
            if (i % 2 == Math.floorMod(nums[i], 2)) {
                oddSt++;
            }
        }
        int minCost = Math.min(evenSt, oddSt);
        int r = Integer.MAX_VALUE;
        if (evenSt == minCost) {
            r = Math.min(r, helper(nums, 0));
        }
        if (oddSt == minCost) {
            r = Math.min(r, helper(nums, 1));
        }
        return new int[] {minCost, r};
    }
    public int helper(int[] nums, int start) {
        List<int[]> values = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int need = (i + start) % 2;
            if (Math.floorMod(nums[i], 2) == need) {
                values.add(new int[]{nums[i], i});
            } else {
                values.add(new int[]{nums[i] - 1, i});
                values.add(new int[]{nums[i] + 1, i});
            }
        }
        values.sort(Comparator.comparingInt(p -> p[0]));
        int l = 0;
        int min = Integer.MAX_VALUE;
        int[] c = new int[nums.length];
        int cover = 0;
        for (int r = 0; r < values.size(); r++) {
            if (c[values.get(r)[1]] == 0) {
                cover++;
            }
            c[values.get(r)[1]]++;
            while (cover == nums.length) {
                int minVal = values.get(l)[0];
                int maxVal = values.get(r)[0];
                min = Math.min(min, maxVal - minVal);
                c[values.get(l)[1]]--;
                if (c[values.get(l)[1]] == 0) {
                    cover--;
                }
                l++;
            }
        }
        return min;
    }
}
