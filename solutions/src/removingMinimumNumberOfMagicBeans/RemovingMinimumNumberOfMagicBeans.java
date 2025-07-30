package removingMinimumNumberOfMagicBeans;

import java.util.Arrays;

public class RemovingMinimumNumberOfMagicBeans {

    public static long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long[] suf = new long[beans.length];
        long sum = beans[beans.length - 1];
        for (int i = beans.length - 2; i >= 0; i--) {
            suf[i] = sum - (long) beans[i] * (beans.length - i - 1);
            sum += beans[i];
        }
        sum = 0;
        long max = Long.MAX_VALUE;
        for (int i = 0; i < beans.length; i++) {
            max = Math.min(sum + suf[i], max);
            sum += beans[i];
        }
        return max;
    }

}
