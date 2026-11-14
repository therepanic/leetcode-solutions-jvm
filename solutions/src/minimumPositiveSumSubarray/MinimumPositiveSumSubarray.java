package minimumPositiveSumSubarray;

import java.util.List;

public class MinimumPositiveSumSubarray {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int a = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;
            for (int j = i; j < nums.size(); j++) {
                if (j - i + 1 > r) {
                    break;
                }
                sum += nums.get(j);
                if (j - i + 1 >= l && sum > 0) {
                    a = Math.min(a, sum);
                }
            }
        }
        return a == Integer.MAX_VALUE ? -1 : a;
    }
}
