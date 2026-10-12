package meanOfArrayAfterRemovingSomeElements;

import java.util.Arrays;

public class MeanOfArrayAfterRemovingSomeElements {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int d = arr.length / 20;
        double ans = 0;
        for (int i = d; i < n - d; i++) {
            ans += arr[i];
        }
        return ans / (n - 2 * d);
    }
}
