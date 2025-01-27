package courseScheduleIV;

import java.util.*;

public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        boolean[][] checked = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            Queue<Integer> bfs = new ArrayDeque<>(List.of(i));

            while (!bfs.isEmpty()) {
                int u = bfs.poll();

                for (int node : graph.get(u)) {
                    if (!checked[i][node]) {
                        checked[i][node] = true;
                        bfs.add(node);
                    }
                }
            }
        }

        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(checked[query[0]][query[1]]);
        }
        return answer;
    }

}
