package lexicographicallySmallestNegatedPermutationThatSumsToTarget;

import java.util.Arrays;

public class LexicographicallySmallestNegatedPermutationThatSumsToTarget {
    public static int[] lexSmallestNegatedPerm(int n, long target) {
        long total = (long) n * (n + 1) / 2;
        if (Math.abs(target) > total) {
            return new int[0];
        }
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        long diff = total - target;
        for (int i = n - 1; i >= 0 && diff > 0; i--) {
            int value = arr[i];
            if (diff >= (long) 2 * value) {
                arr[i] = -value;
                diff -= (long) 2 * value;
            }
        }
        if (diff == 0) {
            Arrays.sort(arr);
            return arr;
        }
        return new int[0];
    }
}
