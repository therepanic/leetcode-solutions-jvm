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
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);

            PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
            heap.add(new int[] {i, 0});
            distances[i] = 0;

            while (!heap.isEmpty()) {
                int[] poll = heap.poll();

                distances[poll[0]] = Math.min(distances[poll[0]], poll[1]);

                if (poll[1] == graph.size()) break;

                for (int curNode : graph.get(poll[0])) {
                    heap.add(new int[] {curNode, poll[1] + 1});
                }
            }
            for (int distance : distances) {
                if (distance > 0 && distance < Integer.MAX_VALUE) {
                    answer[distance - 1]++;
                }
            }
            System.out.println(Arrays.toString(distances));
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] *= 2;
        }
        return answer;
    }
}
