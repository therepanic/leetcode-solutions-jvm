package smallestAbsentPositiveGreaterThanAverage;

import java.util.HashSet;
import java.util.Set;

public class SmallestAbsentPositiveGreaterThanAverage {
    public int smallestAbsent(int[] nums) {
        int avg = 0;
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            avg += val;
            set.add(val);
        }
        avg = (avg / nums.length);
        for (int i = Math.max(avg + 1, 1); i <= Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
