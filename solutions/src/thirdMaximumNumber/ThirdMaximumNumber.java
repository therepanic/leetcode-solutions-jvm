package thirdMaximumNumber;

import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Set<Integer> h = new HashSet<>();
        for (int v : nums) {
            h.add(v);
        }
        int a = Integer.MIN_VALUE;
        for (int v : h) {
            a = Math.max(a, v);
        }
        int b = Integer.MIN_VALUE;
        for (int v : h) {
            if (v < a && v > b) {
                b = v;
            }
        }
        int c = Integer.MIN_VALUE;
        for (int v : h) {
            if (v < a && v < b && v > c) {
                c = v;
            }
        }
        return h.size() < 3 ? a : c;
    }
}
