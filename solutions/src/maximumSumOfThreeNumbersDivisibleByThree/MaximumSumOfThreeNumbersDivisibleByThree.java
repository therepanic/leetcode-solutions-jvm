package maximumSumOfThreeNumbersDivisibleByThree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaximumSumOfThreeNumbersDivisibleByThree {
    public int maximumSum(int[] nums) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int d = nums[i] % 3;
            if (d == 0) {
                a.add(nums[i]);
            } else if (d == 1) {
                b.add(nums[i]);
            } else {
                c.add(nums[i]);
            }
        }
        a.sort(Comparator.reverseOrder());
        b.sort(Comparator.reverseOrder());
        c.sort(Comparator.reverseOrder());
        int ans = 0;
        if (a.size() >= 3) {
            ans = a.get(0) + a.get(1) + a.get(2);
        }
        if (b.size() >= 3) {
            ans = Math.max(b.get(0) + b.get(1) + b.get(2), ans);
        }
        if (c.size() >= 3) {
            ans = Math.max(c.get(0) + c.get(1) + c.get(2), ans);
        }
        if (!a.isEmpty() && !b.isEmpty() && !c.isEmpty()) {
            ans = Math.max(ans, a.get(0) + b.get(0) + c.get(0));
        }
        return ans;
    }
}
