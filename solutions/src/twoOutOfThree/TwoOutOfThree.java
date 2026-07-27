package twoOutOfThree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> num1 = new HashSet<>();
        Set<Integer> num2 = new HashSet<>();
        Set<Integer> num3 = new HashSet<>();
        for (int v : nums1) {
            num1.add(v);
        }
        for (int v : nums2) {
            num2.add(v);
        }
        Set<Integer> distinct = new HashSet<>();
        for (int v : nums3) {
            num3.add(v);
            handle(num1, num2, num3, distinct, v);
        }
        for (int v : nums2) {
            handle(num1, num2, num3, distinct, v);
        }
        for (int v : nums1) {
            handle(num1, num2, num3, distinct, v);
        }
        return new ArrayList<>(distinct);
    }

    private void handle(Set<Integer> num1, Set<Integer> num2, Set<Integer> num3, Set<Integer> ans, int v) {
        int a = 0;
        if (num1.contains(v)) {
            a++;
        }
        if (num2.contains(v)) {
            a++;
        }
        if (num3.contains(v)) {
            a++;
        }
        if (a >= 2) {
            ans.add(v);
        }
    }
}
