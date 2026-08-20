package findTheXOROfNumbersWhichAppearTwice;

import java.util.HashSet;
import java.util.Set;

public class FindTheXOROfNumbersWhichAppearTwice {
    public int duplicateNumbersXOR(int[] nums) {
        int a = 0;
        Set<Integer> num = new HashSet<>();
        for (int v : nums) {
            if (!num.add(v)) {
                a ^= v;
            }
        }
        return a;
    }
}
