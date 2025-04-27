package unitConversionI;

import java.util.*;

public class UnitConversionI {
    public int[] baseUnitConversions(int[][] conversions) {
        int[] answer = new int[conversions.length + 1];
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : conversions) {
            graph.computeIfAbsent(edge[0], p -> new ArrayList<>()).add(new int[] {edge[1], edge[2]});
        }
        Queue<int[]> bfs = new ArrayDeque<>(List.of(new int[] {0, 1}));
        while (!bfs.isEmpty()) {
            int[] poll = bfs.poll();
            if (answer[poll[0]] != 0) continue;
            answer[poll[0]] = poll[1];
            for (int[] edge : graph.getOrDefault(poll[0], List.of())) {
                bfs.add(new int[] {edge[0], ((int) (((long) poll[1] * edge[1]) % (1000000007)))});
            }
        }
        return answer;
    }
}
