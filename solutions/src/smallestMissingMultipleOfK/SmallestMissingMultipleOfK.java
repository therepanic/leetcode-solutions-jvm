package smallestMissingMultipleOfK;

import java.util.HashSet;
import java.util.Set;

public class SmallestMissingMultipleOfK {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> num = new HashSet<>();
        for (int v : nums) {
            num.add(v);
        }
        int one = k;
        while (num.contains(one)) {
            one += k;
        }
        return one;
    }
}
