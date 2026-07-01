package sortItemsByGroupsRespectingDependencies;

import java.util.*;

public class SortItemsByGroupsRespectingDependencies {

    public List<Integer> topoSort(int totalNodes, List<List<Integer>> graph, int[] inDegree) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < totalNodes; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);
            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (order.size() != totalNodes) {
            return null;
        }

        return order;
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> graphGroups = new ArrayList<>();
        List<List<Integer>> graphItems = new ArrayList<>();
        int[] reversedItems = new int[n];
        int nextGroupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = nextGroupId;
                nextGroupId++;
            }
        }
        int[] reversedGroups = new int[nextGroupId];
        for (int i = 0; i < nextGroupId; i++) {
            graphGroups.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            graphItems.add(new ArrayList<>());
        }
        Set<String> blockedGroup = new HashSet<>();
        for (int i = 0; i < beforeItems.size(); i++) {
            for (int j = 0; j < beforeItems.get(i).size(); j++) {
                int parent = beforeItems.get(i).get(j);
                String tag = group[i] + "-" + group[parent];
                if (group[i] != group[parent] && !blockedGroup.contains(tag)) {
                    blockedGroup.add(tag);
                    graphGroups.get(group[parent]).add(group[i]);
                    reversedGroups[group[i]]++;
                }
                graphItems.get(parent).add(i);
                reversedItems[i]++;
            }
        }
        List<Integer> groupsOrder = topoSort(nextGroupId, graphGroups, reversedGroups);
        if (groupsOrder == null) {
            return new int[0];
        }
        List<Integer> itemsOrder = topoSort(n, graphItems, reversedItems);
        if (itemsOrder == null) {
            return new int[0];
        }
        Map<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (int item : itemsOrder) {
            int g = group[item];
            groupToItems.computeIfAbsent(g, _ -> new ArrayList<>()).add(item);
        }
        int[] result = new int[n];
        int index = 0;
        for (int g : groupsOrder) {
            List<Integer> itemsInGroup = groupToItems.get(g);
            if (itemsInGroup != null) {
                for (int item : itemsInGroup) {
                    result[index++] = item;
                }
            }
        }
        return result;
    }
}
