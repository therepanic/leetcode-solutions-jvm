package operationOnTree;

import java.util.*;

public class LockingTree {

    private final List<List<Integer>> graph;
    private final List<List<Integer>> reversedGraph;
    private final Map<Integer, Integer> banned;

    public LockingTree(int[] parent) {
        this.graph = new ArrayList<>(parent.length);
        this.reversedGraph = new ArrayList<>(parent.length);
        for (int i = 0; i < parent.length; i++) {
            this.graph.add(new ArrayList<>());
            this.reversedGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) continue;
            this.graph.get(parent[i]).add(i);
            this.reversedGraph.get(i).add(parent[i]);
        }
        this.banned = new HashMap<>();
    }

    public boolean lock(int num, int user) {
        if (this.banned.containsKey(num)) return false;
        this.banned.put(num, user);
        return true;
    }

    public boolean unlock(int num, int user) {
        if (!this.banned.containsKey(num) || !this.banned.get(num).equals(user)) return false;
        this.banned.remove(num);
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (this.banned.containsKey(num)) {
            return false;
        }
        if (dfs(this.reversedGraph, num)) {
            return false;
        }
        if (!dfs(this.graph, num)) {
            return false;
        }
        unban(graph, num);
        this.banned.put(num, user);
        return true;
    }

    public void unban(List<List<Integer>> graph, int node) {
        this.banned.remove(node);
        for (int v : graph.get(node)) {
            unban(graph, v);
        }
    }

    public boolean dfs(List<List<Integer>> graph, int node) {
        if (this.banned.containsKey(node)) {
            return true;
        }
        for (int v : graph.get(node)) {
            boolean res = dfs(graph, v);
            if (res) {
                return true;
            }
        }
        return false;
    }
}
