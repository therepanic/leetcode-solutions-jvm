package courseScheduleII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
            return new int[0];
        }

        int[] order = new int[numCourses];
        int orderIndex = 0;

        while (!nodesWithoutIncomingEdges.isEmpty()) {
            int nodeValue = nodesWithoutIncomingEdges.poll();

            order[orderIndex] = nodeValue;
            orderIndex++;
            currentNumCourses--;

            for (int j : graph.get(nodeValue)) {
                incomingEdges.get(j).remove(Integer.valueOf(nodeValue));

                if (incomingEdges.get(j).isEmpty()) {
                    nodesWithoutIncomingEdges.add(j);
                }
            }
        }

        if (currentNumCourses == 0) {
            for (int i = 0; i < order.length / 2; i++) {
                int buffer = order[i];

                order[i] = order[order.length - i - 1];
                order[order.length - i - 1] = buffer;
            }
        }

        return currentNumCourses == 0 ? order : new int[0];
    }
}
