package timeNeededToInformAllEmployees;

import java.util.ArrayList;
import java.util.List;

public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) continue;
            graph.get(manager[i]).add(i);
        }

        return bypass(headID, informTime, 0, graph);
    }

    public int bypass(int node, int[] informTime, int time, List<List<Integer>> graph) {
        int maxTime = time;
        for (int curNode : graph.get(node)) {
            maxTime = Math.max(bypass(curNode, informTime, time + informTime[node], graph), maxTime);
        }

        return maxTime;
    }
}
