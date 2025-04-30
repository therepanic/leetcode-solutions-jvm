package removeMethodsFromProject;

import java.util.ArrayList;
import java.util.List;

public class RemoveMethodsFromProject {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reversedGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }
        for (int[] invocation : invocations) {
            graph.get(invocation[0]).add(invocation[1]);
            reversedGraph.get(invocation[1]).add(invocation[0]);
        }
        boolean[] visited = new boolean[n];
        bypass(graph, k, visited);
        boolean[] signal = new boolean[1];
        bypass2(graph, reversedGraph, k, visited, signal, new boolean[n]);
        List<Integer> nums = new ArrayList<>();
        if (signal[0]) {
            for (int i = 0; i < n; i++) {
                nums.add(i);
            }
        } else {
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    nums.add(i);
                }
            }
        }
        return nums;
    }

    public void bypass2(List<List<Integer>> graph, List<List<Integer>> reversedGraph, int node, boolean[] visited, boolean[] signal, boolean[] visited2) {
        if (visited2[node]) return;
        visited2[node] = true;
        for (int v : reversedGraph.get(node)) {
            if (!visited[v]) {
                signal[0] = true;
                return;
            }
        }
        if (signal[0]) return;
        for (int v : graph.get(node)) {
            bypass2(graph, reversedGraph, v, visited, signal, visited2);
        }
    }
    public void bypass(List<List<Integer>> graph, int node, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;
        for (int v : graph.get(node)) {
            bypass(graph, v, visited);
        }
    }

}
