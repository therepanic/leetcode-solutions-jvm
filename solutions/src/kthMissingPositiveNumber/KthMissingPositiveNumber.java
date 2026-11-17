package kthMissingPositiveNumber;

import java.util.HashSet;
import java.util.Set;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> a = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            a.add(arr[i]);
        }
        int b = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!a.contains(i)) {
                b++;
                if (b == k) {
                    return i;
                }
            }
        }
        return -1;
    }
}
