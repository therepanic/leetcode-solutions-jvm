package findTheDistinctDifferenceArray;

import java.util.HashSet;
import java.util.Set;

public class FindTheDistinctDifferenceArray {
    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> disA = new HashSet<>();
        Set<Integer> disB = new HashSet<>();
        int[] pref = new int[nums.length];
        int[] suf = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            disA.add(nums[i]);
            pref[i] = disA.size();
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            disB.add(nums[i]);
            suf[i] = disB.size();
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                ans[i] = pref[i];
            } else {
                ans[i] = pref[i] - suf[i + 1];
            }
        }
        return ans;
    }
}
