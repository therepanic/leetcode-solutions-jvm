package countTheNumberOfHousesAtACertainDistanceI;

import java.util.*;

public class CountTheNumberOfHousesAtACertainDistanceI {
    public int[] countOfPairs(int n, int x, int y) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            graph.get(i - 1).add(i);
        }
        x--;
        y--;
        graph.get(x).add(y);
        System.out.println(graph);

        for (int i = 0; i < n; i++) {
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);

            PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
            heap.add(new int[] {i, 0});

            while (!heap.isEmpty()) {
                int[] poll = heap.poll();

                if (poll[1] == graph.size()) break;

                distances[i] = Math.min(distances[i], poll[1]);

                for (int curNode : graph.get(poll[0])) {
                    heap.add(new int[] {curNode, poll[1] + 1});
                }
            }

            System.out.println(Arrays.toString(distances));
        }

        return null;
    }
}
