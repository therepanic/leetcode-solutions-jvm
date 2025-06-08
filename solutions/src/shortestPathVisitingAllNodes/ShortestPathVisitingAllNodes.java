package shortestPathVisitingAllNodes;

import java.util.*;

public class ShortestPathVisitingAllNodes {

    public int shortestPathLength(int[][] graph) {
        int mask = 0;
        List<List<Integer>> graphList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            mask |= (1 << i);
            graphList.add(new ArrayList<>());
            for (int node : graph[i]) {
                graphList.get(i).add(node);
            }
        }
        int answer = Integer.MAX_VALUE;
        Queue<int[]> bfs = new ArrayDeque<>();
        boolean[][] visited = new boolean[mask + 1][graph.length];
        for (int i = 0; i < graph.length; i++) {
            bfs.add(new int[]{i, 0, 0});
        }
        while (!bfs.isEmpty()) {
            int[] poll = bfs.poll();
            if ((poll[1] & (1 << poll[0])) == 0) {
                poll[1] |= (1 << poll[0]);
            }
            if (visited[poll[1]][poll[0]]) {
                continue;
            }
            visited[poll[1]][poll[0]] = true;
            if (poll[1] == mask) {
                return poll[2];
            }
            for (int node : graphList.get(poll[0])) {
                bfs.add(new int[] {node, poll[1], poll[2] + 1});
            }
        }
        return answer;
    }

}
