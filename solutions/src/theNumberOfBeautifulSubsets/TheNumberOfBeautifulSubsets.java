package theNumberOfBeautifulSubsets;

import java.util.HashSet;
import java.util.Set;

public class TheNumberOfBeautifulSubsets {
    public int beautifulSubsets(int[] nums, int k) {
        int[] ans = new int[] {-1};
        helper(nums, new HashSet<>(), 0, k, ans);
        return ans[0];
    }

    void helper(int[] nums, Set<Integer> saved, int i, int k, int[] ans) {
        if (i == nums.length) {
            ans[0]++;
            return;
        }
        if (!saved.contains(nums[i] - k) && !saved.contains(nums[i] + k)) {
            Set<Integer> n = new HashSet<>(saved);
            n.add(nums[i]);
            helper(nums, n,i + 1, k, ans);
        }
        helper(nums, saved, i + 1, k, ans);
    }
}
