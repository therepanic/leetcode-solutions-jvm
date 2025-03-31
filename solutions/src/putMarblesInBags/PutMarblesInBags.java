package putMarblesInBags;

import java.util.Arrays;

public class PutMarblesInBags {
    public long putMarbles(int[] weights, int k) {
        int[] sum = new int[weights.length - 1];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(sum);
        long min = 0;
        long max = 0;
        k--;
        for (int i = 0; i < k; i++) {
            min += sum[i];
            max += sum[sum.length - i - 1];
        }
        return max - min;
    }
}
