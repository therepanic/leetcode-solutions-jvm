package sortIntegersByTheNumberOf1Bits;

import java.util.Arrays;

public class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        int[][] entries = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int c = Integer.bitCount(val);
            entries[i] = new int[] {c, arr[i]};
        }
        Arrays.sort(entries, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            } else {
                return Integer.compare(p1[0], p2[0]);
            }
        });
        int[] ans = new int[entries.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = entries[i][1];
        }
        return ans;
    }
}
