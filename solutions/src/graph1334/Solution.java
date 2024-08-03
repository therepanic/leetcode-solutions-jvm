package graph1334;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findTheCity(4, new int[][] {{0,1,3},{1,2,1},{1,3,4},{2,3,1}}, 4));
        System.out.println(findTheCity(5, new int[][] {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2));
    }
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int citiesCount = Integer.MAX_VALUE;
        int city = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);

            distances[i] = 0;

            Queue<int[]> edgeQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

            for (int[] edge : edges) {
                if (edge[0] == i) {
                    edgeQueue.add(new int[] {edge[1], edge[2]});

                    distances[edge[1]] = Math.min(edge[2], distances[edge[1]]);
                } else if (edge[1] == i) {
                    edgeQueue.add(new int[] {edge[0], edge[2]});

                    distances[edge[0]] = Math.min(edge[2], distances[edge[0]]);
                }
            }

            while (!edgeQueue.isEmpty()) {
                int[] currentEdge = edgeQueue.poll();

                if (currentEdge[1] > distances[currentEdge[0]]) {
                    continue;
                }

                for (int[] edge : edges) {
                    if (edge[0] == currentEdge[0]) {
                        distances[edge[1]] = Math.min(distances[edge[1]], currentEdge[1] + edge[2]);

                        edgeQueue.add(new int[] {edge[1], currentEdge[1] + edge[2]});
                    } else if (edge[1] == currentEdge[0]) {
                        distances[edge[0]] = Math.min(distances[edge[0]], currentEdge[1] + edge[2]);

                        edgeQueue.add(new int[] {edge[0], currentEdge[1] + edge[2]});
                    }
                }
            }

            int currentCitiesThresholdCount = 1;

            for (int distance : distances) {
                if (distance <= distanceThreshold) {
                    currentCitiesThresholdCount++;
                }
            }

            if (currentCitiesThresholdCount < citiesCount) {
                citiesCount = currentCitiesThresholdCount;
                city = i;
            } else if (currentCitiesThresholdCount == citiesCount) {
                city = Math.max(city, i);
            }

            System.out.println(Arrays.toString(distances));

        }

        return city;
    }
}
