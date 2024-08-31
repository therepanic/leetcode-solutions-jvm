package sumOfDistancesInTree;

import java.util.*;

public class SumOfDistancesInTree {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        int[] reversedGraphCount = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

            reversedGraphCount[edge[1]]++;
        }

        int[] key = new int[1];

        for (int i = 0; i < n; i++) {
            if (reversedGraphCount[i] == 0) {
                key[0] = i;
                break;
            }
        }

        Set<Integer> checked = new HashSet<>();
        int[] sumOfDistances = new int[n];

        Map<Integer, Integer> nodeCountMap = new HashMap<>();

        int[] totalDistance = new int[1];

        getAllHeightAndDistance(key[0], graph, nodeCountMap, checked, 0, totalDistance);

        int distanceForZero = totalDistance[0];

        checked.clear();

        helper(key[0], graph, nodeCountMap, sumOfDistances, key[0], distanceForZero, key, checked);

        return sumOfDistances;
    }

    public void helper(int value, List<List<Integer>> graph, Map<Integer, Integer> nodeCountMap, int[] sumOfDistances, int i, int sumDistance, int[] key,
                       Set<Integer> checked) {
        checked.add(value);

        int up = nodeCountMap.get(key[0]);
        int down = nodeCountMap.get(value);

        if (value != key[0]) {
            up -= down;
        }

        sumDistance -= down;
        sumDistance += up;

        sumOfDistances[i] = sumDistance;

        for (int node : graph.get(value)) {
            if (!checked.contains(node)) {
                helper(node, graph, nodeCountMap, sumOfDistances, node, sumDistance, key, checked);
            }
        }
    }

    public int getAllHeightAndDistance(int value, List<List<Integer>> graph, Map<Integer, Integer> nodeCountMap, Set<Integer> checked, int distance, int[] totalDistance) {
        checked.add(value);
        int currentHeight = 1;

        totalDistance[0] += distance;

        for (int node : graph.get(value)) {
            if (!checked.contains(node)) {
                currentHeight += getAllHeightAndDistance(node, graph, nodeCountMap, checked, distance + 1, totalDistance);
            }
        }

        nodeCountMap.put(value, currentHeight);
        return currentHeight;
    }
}
