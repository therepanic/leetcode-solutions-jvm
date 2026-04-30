package minimumImpossibleOR;

import java.util.HashSet;
import java.util.Set;

public class MinimumImpossibleOR {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int j = 0; j < 32; j++) {
            if (!set.contains(1 << j)) {
                return (1 << j);
            }
        }
        return -1;
    }
}
