package maximizeTheTotalHeightOfUniqueTowers;

import java.util.Arrays;

public class MaximizeTheTotalHeightOfUniqueTowers {

    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        long count = 0;
        long max = Long.MAX_VALUE;
        for (int i = maximumHeight.length - 1; i >= 0; i--) {
            long c = Math.min(maximumHeight[i], max - 1);
            if (c == 0) return -1;
            count += c;
            max = c;
        }
        return count;
    }

}
