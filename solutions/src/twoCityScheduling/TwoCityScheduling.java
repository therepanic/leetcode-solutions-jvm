package twoCityScheduling;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(p -> p[0] - p[1]));
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][0] + costs[i + costs.length / 2][1];
        }
        return cost;
    }
}
