package minimumCostOfAPathWithSpecialRoads;

import java.util.*;

public class MinimumCostOfAPathWithSpecialRoads {

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));
        Map<String, List<int[]>> roads = new HashMap<>();
        for (int[] spec : specialRoads) {
            heap.add(new int[] {spec[0], spec[1], manhattan(start[0], spec[0], start[1], spec[1])});
            String key = spec[0] + "-" + spec[1];
            roads.computeIfAbsent(key, p -> new ArrayList<>()).add(new int[] {spec[2], spec[3], spec[4]});
        }
        heap.add(new int[] {target[0], target[1], manhattan(start[0], target[0], start[1], target[1])});
        Map<String, Integer> visited = new HashMap<>();
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            if (poll[0] == target[0] && poll[1] == target[1]) {
                return poll[2];
            }
            String key = poll[0] + "-" + poll[1];
            if (visited.containsKey(key) && poll[2] >= visited.get(key)) {
                continue;
            }
            visited.put(key, poll[2]);
            for (int[] road : specialRoads) {
                heap.add(new int[] {road[0], road[1], manhattan(poll[0], road[0], poll[1], road[1]) + poll[2]});
            }
            for (int[] road : roads.getOrDefault(key, List.of())) {
                heap.add(new int[] {road[0], road[1], road[2] + poll[2]});
            }
            heap.add(new int[] {target[0], target[1], manhattan(poll[0], target[0], poll[1], target[1]) + poll[2]});
        }
        return -1;
    }

    private int manhattan(int x1, int x2, int y1, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

}
