package maximizeSumOfAtMostKDistinctElements;

import java.util.*;

public class MaximizeSumOfAtMostKDistinctElements {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> values = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0 && k != 0; i--) {
            if (!values.contains(nums[i])) {
                values.add(nums[i]);
                ans.add(nums[i]);
                k--;
            }
        }
        int[] a = new int[ans.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans.get(i);
        }
        return a;
    }
}
