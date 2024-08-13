package networkDelayTime;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        k--;

        List<List<Integer>> graph = new ArrayList<>();
        Map<Integer, Map<Integer, Integer>> nodeTimes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            time[0]--;
            time[1]--;

            graph.get(time[0]).add(time[1]);

            if (!nodeTimes.containsKey(time[0])) {
                nodeTimes.put(time[0], new HashMap<>(Map.of(time[1], time[2])));
            } else {
                nodeTimes.get(time[0]).put(time[1], time[2]);
            }
        }

        int[] edges = new int[n];
        Arrays.fill(edges, Integer.MAX_VALUE);

        edges[k] = 0;

        PriorityQueue<int[]> edgeQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        for (int node : graph.get(k)) {
            edgeQueue.add(new int[] {k, node, nodeTimes.get(k).get(node)});
        }

        while (!edgeQueue.isEmpty()) {
            int[] edgeValue = edgeQueue.poll();

            edges[edgeValue[1]] = Math.min(edgeValue[2], edges[edgeValue[1]]);

            for (int edge : graph.get(edgeValue[1])) {
                if (edges[edge] > edgeValue[2] + nodeTimes.get(edgeValue[1]).get(edge)) {
                    edgeQueue.add(new int[] {edgeValue[1], edge, edgeValue[2] + nodeTimes.get(edgeValue[1]).get(edge)});
                }
            }

        }

        int answer = -1;

        for (int edge : edges) {
            if (Integer.MAX_VALUE != edge) {
                answer = Math.max(answer, edge);
            } else {
                return -1;
            }
        }

        return answer;
    }
}
