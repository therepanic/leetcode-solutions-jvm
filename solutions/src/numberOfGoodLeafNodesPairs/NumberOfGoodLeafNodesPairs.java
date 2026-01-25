package numberOfGoodLeafNodesPairs;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfGoodLeafNodesPairs {
    public int countPairs(TreeNode root, int distance) {
        int[] count = new int[1];
        Set<Integer> leaves = new HashSet<>();
        recolor(root, count, leaves);
        int n = count[0] + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        buildGraph(root, graph);
        boolean[] visited = new boolean[n];
        int[] sum = new int[1];
        for (int v : leaves) {
            check(v, graph, visited.clone(), distance, 0, leaves, sum, true);
            visited[v] = true;
        }
        return sum[0];
    }

    public void check(int node, List<List<Integer>> graph, boolean[] visited, int distance, int curDistance,
                      Set<Integer> leaves, int[] sum, boolean ok) {
        if (visited[node]) return;
        if (curDistance > distance) {
            return;
        }
        visited[node] = true;
        if (leaves.contains(node) && !ok) {
            sum[0]++;
            return;
        }
        for (int v : graph.get(node)) {
            check(v, graph, visited, distance, curDistance + 1, leaves, sum, false);
        }
    }

    public void recolor(TreeNode root, int[] count, Set<Integer> leaves) {
        root.val = count[0];
        count[0]++;
        if (root.left != null) {
            recolor(root.left, count, leaves);
        }
        if (root.right != null) {
            recolor(root.right, count, leaves);
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
    }

    public void buildGraph(TreeNode root, List<List<Integer>> graph) {
        if (root.left != null) {
            graph.get(root.val).add(root.left.val);
            graph.get(root.left.val).add(root.val);
            buildGraph(root.left, graph);
        }
        if (root.right != null) {
            graph.get(root.val).add(root.right.val);
            graph.get(root.right.val).add(root.val);
            buildGraph(root.right, graph);
        }
    }

}
