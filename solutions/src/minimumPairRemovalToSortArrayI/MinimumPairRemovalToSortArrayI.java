package minimumPairRemovalToSortArrayI;

import java.util.ArrayList;
import java.util.List;

public class MinimumPairRemovalToSortArrayI {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            vals.add(nums[i]);
        }
        int c = 0;
        while (!isSorted(vals)) {
            int minSum = Integer.MAX_VALUE;
            int minIt = -1;
            for (int i = 0; i < vals.size() - 1; i++) {
                int curSum = vals.get(i) + vals.get(i + 1);
                if (curSum < minSum) {
                   minSum = curSum;
                   minIt = i;
                }
            }
            vals.remove(minIt);
            vals.remove(minIt);
            vals.add(minIt, minSum);
            c++;
        }
        return c;
    }
    public boolean isSorted(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) return false;
        }
        return true;
    }
}
