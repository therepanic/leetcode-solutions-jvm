package maximumXOROfTwoNumbersInAnArray;

import java.util.HashSet;
import java.util.Set;

public class MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> bits = new HashSet<>();
            for (int val : nums) {
                bits.add(val & mask);
            }
            int tmp = max | (1 << i);
            for (int val : bits) {
                if (bits.contains(tmp ^ val)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
