package powerGridMaintenance;

import java.util.*;

public class PowerGridMaintenance {

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int oneQueryCount = 0;
        for (int[] query : queries) {
            query[1]--;
            if (query[0] == 1) {
                oneQueryCount++;
            }
        }
        int[] answer = new int[oneQueryCount];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            connection[0]--;
            connection[1]--;
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }
        Set<Integer> banned = new HashSet<>();
        Map<Integer, PriorityQueue<Integer>> nodeHeapMap = new HashMap<>();
        Map<Integer, Integer> unionMap = new HashMap<>();
        int unionIt = 0;
        boolean[] visited = new boolean[c];
        for (int i = 0; i < c; i++) {
            if (!visited[i]) {
                bypass(i, graph, unionIt, nodeHeapMap, visited, unionMap);
                unionIt++;
            }
        }
        int it = 0;
        for (int[] query : queries) {
            if (query[0] == 2) {
                banned.add(query[1]);
            } else {
                if (!banned.contains(query[1])) {
                    answer[it] = query[1] + 1;
                } else {
                    int union = unionMap.get(query[1]);
                    var heap = nodeHeapMap.get(union);
                    while (!heap.isEmpty() && banned.contains(heap.peek())) {
                        heap.poll();
                    }
                    if (heap.isEmpty()) {
                        answer[it] = -1;
                    } else {
                        answer[it] = heap.peek() + 1;
                    }
                }
                it++;
            }
        }
        return answer;
    }

    private void bypass(int node, List<List<Integer>> graph, int unionIt, Map<Integer, PriorityQueue<Integer>> nodeHeapMap, boolean[] visited,
                        Map<Integer, Integer> unionMap) {
        if (visited[node]) return;
        nodeHeapMap.computeIfAbsent(unionIt, p -> new PriorityQueue<>()).add(node);
        unionMap.put(node, unionIt);
        visited[node] = true;
        for (int v : graph.get(node)) {
            bypass(v, graph, unionIt, nodeHeapMap, visited, unionMap);
        }
    }

}
