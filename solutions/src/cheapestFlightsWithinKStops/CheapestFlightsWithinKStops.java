package cheapestFlightsWithinKStops;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(c -> c[1]));
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }
        minHeap.add(new int[] {src, 0, 0});

        int[][] minCosts = new int[n][k + 2];
        for (int[] row : minCosts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minCosts[src][0] = 0;

        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.poll();

            if (poll[0] == dst) {
                return poll[1];
            }

            if (poll[2] > k) {
                continue;
            }

            int cost = poll[1];
            int steps = poll[2];

            for (int[] curNode : graph.get(poll[0])) {
                int nextNode = curNode[0];
                int newCost = cost + curNode[1];
                int newSteps = steps + 1;

                if (newSteps <= k + 1 && newCost < minCosts[nextNode][newSteps]) {
                    minCosts[nextNode][newSteps] = newCost;
                    minHeap.add(new int[]{nextNode, newCost, newSteps});
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int steps = 0; steps <= k + 1; steps++) {
            result = Math.min(result, minCosts[dst][steps]);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
