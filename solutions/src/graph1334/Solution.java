package graph1334;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findTheCity(4, new int[][] {{0,1,3},{1,2,1},{1,3,4},{2,3,1}}, 4));
        //System.out.println(findTheCity(5, new int[][] {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2));
    }
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int cityCount = helper(edges, i, i, 0, distanceThreshold, new HashSet<>());

            System.out.println("Data: " + i + " " + cityCount);
            if (map.containsKey(cityCount)) {
                map.get(cityCount).add(i);
            } else {
                map.put(cityCount, new PriorityQueue<>(Collections.reverseOrder()));
                map.get(cityCount).add(i);
            }
        }

        return map.values().iterator().next().peek();
    }

    public static int helper(int[][] edges, int startN, int n, int distance, int distanceThreshold, Set<Integer> visited) {
        if (distance > distanceThreshold) {
            return 0;
        } else if (distance == distanceThreshold){
            return 1;
        }

        int cityCountSum = 0;

        if (startN != n) {
            cityCountSum = 1;
        }


        visited.add(n);

        for (int[] edge : edges) {
            if (edge[0] == n && !visited.contains(edge[1])) {
                System.out.println(n + " " + edge[1]);

                cityCountSum += helper(edges, startN, edge[1], distance + edge[2], distanceThreshold, visited);
            } else if (edge[1] == n && !visited.contains(edge[0])) {
                System.out.println(n + " " + edge[0]);

                cityCountSum += helper(edges, startN, edge[0], distance + edge[2], distanceThreshold, visited);
            }
        }

        visited.remove(n);

        return cityCountSum;
    }
}
