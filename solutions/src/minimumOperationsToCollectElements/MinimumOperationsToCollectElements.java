package minimumOperationsToCollectElements;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumOperationsToCollectElements {
    public int minOperations(List<Integer> nums, int k) {
        int a = 0;
        int i;
        Set<Integer> c = new HashSet<>();
        for (i = nums.size() - 1; i >= 0 && a != k; i--) {
            int b = nums.get(i);
            if (b >= 1 && b <= k && c.add(b)) {
                a++;
            }
        }
        return nums.size() - i - 1;
    }
}
