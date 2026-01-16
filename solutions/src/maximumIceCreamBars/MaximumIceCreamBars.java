package maximumIceCreamBars;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            coins -= costs[i];
            if (coins < 0) {
                return i;
            }
        }
        return costs.length;
    }
}
