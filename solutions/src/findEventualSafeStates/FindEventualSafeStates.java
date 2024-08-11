package findEventualSafeStates;

import java.util.*;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> incomingEdges = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            incomingEdges.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int value : graph[i]) {
                incomingEdges.get(value).add(i);
            }
        }

        Set<Integer> checked = new HashSet<>();

        Queue<Integer> withoutOutComingEdges = new ArrayDeque<>();

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                withoutOutComingEdges.add(i);
                checked.add(i);
            }
        }

        while (!withoutOutComingEdges.isEmpty()) {
            int nodeValue = withoutOutComingEdges.poll();

            for (int value1 : incomingEdges.get(nodeValue)) {
                boolean isHasAllCheckedValues = true;

                for (int value2 : graph[value1]) {
                    if (!checked.contains(value2)) {
                        isHasAllCheckedValues = false;
                        break;
                    }
                }

                if (isHasAllCheckedValues) {
                    checked.add(value1);
                    withoutOutComingEdges.add(value1);
                }
            }
        }

        List<Integer> eventualSafeNodes = new ArrayList<>(checked);

        Collections.sort(eventualSafeNodes);
        return eventualSafeNodes;
    }
}
