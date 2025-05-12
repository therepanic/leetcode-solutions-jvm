package maximumStarSumOfAGraph;

import java.util.*;

public class MaximumStarSumOfAGraph {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vals.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < graph.size(); i++) {
            PriorityQueue<Integer> high = new PriorityQueue<>(Comparator.reverseOrder());
            int sum = vals[i];
            for (int node : graph.get(i)) {
                high.add(vals[node]);
            }
            int kCopy = k;
            while (kCopy != 0 && !high.isEmpty()) {
                maxSum = Math.max(sum, maxSum);
                sum += high.poll();
                kCopy--;
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
