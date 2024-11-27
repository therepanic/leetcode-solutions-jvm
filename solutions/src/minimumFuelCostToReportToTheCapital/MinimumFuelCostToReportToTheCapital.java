package minimumFuelCostToReportToTheCapital;

import java.util.ArrayList;
import java.util.List;

public class MinimumFuelCostToReportToTheCapital {
    public long minimumFuelCost(int[][] roads, int seats) {
        long sum = 0;
        List<List<Integer>> graph = new ArrayList<>();
        int n = Integer.MIN_VALUE;

        for (int[] road : roads) {
            n = Math.max(n, road[0]);
            n = Math.max(n, road[1]);
        }

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][1]).add(roads[i][10]);
        }


    }

    public void dfs()
}
