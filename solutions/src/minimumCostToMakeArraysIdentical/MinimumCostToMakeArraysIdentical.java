package minimumCostToMakeArraysIdentical;

import java.util.Arrays;

public class MinimumCostToMakeArraysIdentical {
    public long minCost(int[] arr, int[] brr, long k) {
        long a = 0;
        long b = 0;
        for (int i = 0; i < arr.length; i++) {
            a += Math.abs(arr[i] - brr[i]);
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        for (int i = 0; i < arr.length; i++) {
            b += Math.abs(arr[i] - brr[i]);
        }
        return Math.min(a, b + k);
    }
}
