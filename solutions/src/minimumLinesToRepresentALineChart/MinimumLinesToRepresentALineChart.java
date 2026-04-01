package minimumLinesToRepresentALineChart;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumLinesToRepresentALineChart {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        int ans = stockPrices.length - 1;
        for (int i = 1; i < stockPrices.length - 1; i++) {
            int y0 = stockPrices[i - 1][1];
            int y1 = stockPrices[i][1];
            int y2 = stockPrices[i + 1][1];
            int x0 = stockPrices[i - 1][0];
            int x1 = stockPrices[i][0];
            int x2 = stockPrices[i + 1][0];
            if ((long) (y1 - y0) * (x2 - x1) == (long) (y2 - y1) * (x1 - x0)) {
                ans--;
            }
        }
        return ans;
    }
}
