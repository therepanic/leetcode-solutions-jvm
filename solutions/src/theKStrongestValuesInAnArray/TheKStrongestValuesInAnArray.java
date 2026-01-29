package theKStrongestValuesInAnArray;

import java.util.Arrays;

public class TheKStrongestValuesInAnArray {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        int[][] pair = new int[arr.length][2];
        for (int i = 0; i < pair.length; i++) {
            pair[i] = new int[] {Math.abs(arr[i] - m), arr[i]};
        }
        Arrays.sort(pair, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p2[1], p1[1]);
            } else {
                return Integer.compare(p2[0], p1[0]);
            }
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pair[i][1];
        }
        return ans;
    }
}
