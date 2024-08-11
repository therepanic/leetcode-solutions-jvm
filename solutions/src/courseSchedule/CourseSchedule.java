package courseSchedule;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> incomingEdges = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
            incomingEdges.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
            incomingEdges.get(edge[1]).add(edge[0]);
        }

        //base

        int currentNumCourses = numCourses;
        Queue<Integer> nodesWithoutIncomingEdges = new ArrayDeque<>();

        for (int i = 0; i < graph.size(); i++) {
            if (incomingEdges.get(i).isEmpty()) {
                nodesWithoutIncomingEdges.add(i);
            }
        }

        if (nodesWithoutIncomingEdges.isEmpty()) {
            return false;
        }

        while (!nodesWithoutIncomingEdges.isEmpty()) {
            int nodeValue = nodesWithoutIncomingEdges.poll();

            currentNumCourses--;

            for (int j : graph.get(nodeValue)) {
                incomingEdges.get(j).remove(Integer.valueOf(nodeValue));

                if (incomingEdges.get(j).isEmpty()) {
                    nodesWithoutIncomingEdges.add(j);
                }
            }
        }

        return currentNumCourses == 0;
    }
}
