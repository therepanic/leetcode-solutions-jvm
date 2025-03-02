package findSubtreeSizesAfterChanges;

import java.util.*;

public class FindSubtreeSizesAfterChanges {
    public int[] findSubtreeSizes(int[] parent, String s) {
        char[] sChars = s.toCharArray();
        List<Set<Integer>> graph = new ArrayList<>();
        int[] deGraph = new int[parent.length];
        for (int i = 0; i < parent.length; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) continue;
            graph.get(parent[i]).add(i);
            deGraph[i] = parent[i];
        }
        Queue<int[]> nodesToChange = new ArrayDeque<>();
        int[] filled = new int[26];
        Arrays.fill(filled, -1);
        bypass(0, graph, filled, -1, sChars, nodesToChange);
        while (!nodesToChange.isEmpty()) {
            int[] swap = nodesToChange.poll();
            int cur = deGraph[swap[0]];
            deGraph[swap[0]] = swap[1];
            graph.get(cur).remove(swap[0]);
            graph.get(swap[1]).add(swap[0]);
        }
        int[] subtreeSizes = new int[parent.length];
        dfs(0, graph, subtreeSizes);
        return subtreeSizes;
    }

    private void bypass(int node, List<Set<Integer>> graph, int[] change, int prev, char[] sChars, Queue<int[]> nodesToChange) {
        int charNodeVal = sChars[node] - 'a';
        int old = change[charNodeVal];
        change[charNodeVal] = node;
        if (old != -1 && prev != old) {
            nodesToChange.add(new int[] {node, old});
        }
        for (int curNode : graph.get(node)) {
            bypass(curNode, graph, change, node, sChars, nodesToChange);
        }
        change[charNodeVal] = old;
    }

    private int dfs(int node, List<Set<Integer>> graph, int[] subtreeSizes) {
        int size = 1;
        for (int child : graph.get(node)) {
            size += dfs(child, graph, subtreeSizes);
        }
        subtreeSizes[node] = size;
        return size;
    }
}
