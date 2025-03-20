package minimumCostWalkInWeightedGraph;

import java.util.*;

public class MinimumCostWalkInWeightedGraph {
    public static int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] ed : edges) {
            graph.get(ed[0]).add(new int[] {ed[1], ed[2]});
            graph.get(ed[1]).add(new int[] {ed[0], ed[2]});
        }
        int[] visited = new int[n];
        int unique = 1;
        List<Integer> d = new ArrayList<>();
        Map<Integer, Integer> check = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                Set<Integer> path = new HashSet<>();
                bypass(i, graph, visited, unique, path, check);
                if (path.isEmpty()) continue;
                int dNum = -1;
                for (int p : path) {
                    if (dNum == -1) {
                        dNum = p;
                        continue;
                    }
                    dNum &= p;
                }
                d.add(dNum);
                unique++;
            }
        }
        int[] answer = new int[query.length];
        int it = 0;
        for (int[] entry : query) {
            if (graph.get(entry[0]).isEmpty() || graph.get(entry[1]).isEmpty()) {
                answer[it] = -1;
                it++;
                continue;
            }
            if (!check.getOrDefault(entry[0], -1).equals(check.getOrDefault(entry[1], -2))) {
                answer[it] = -1;
            } else {
                answer[it] = d.get(check.get(entry[0]) - 1);
            }
            it++;
        }
        return answer;
    }

    private static void bypass(int curNode, List<List<int[]>> graph, int[] visited, int unique, Set<Integer> allNums, Map<Integer, Integer> check) {
        visited[curNode] = unique;
        check.put(curNode, unique);
        for (int[] node : graph.get(curNode)) {
            allNums.add(node[1]);
            if (visited[node[0]] == 0) {
                bypass(node[0], graph, visited, unique, allNums, check);
            }
        }
    }
}
