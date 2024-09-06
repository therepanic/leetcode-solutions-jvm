package allNodesDistanceKInBinaryTree;

import structures.treeNode.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        bypass(root, graph);

        List<Integer> distanceNodes = new ArrayList<>();

        checkOnDistance(distanceNodes, graph, new HashSet<>(), target.val, 0, k);

        return distanceNodes;
    }

    public void checkOnDistance(List<Integer> distanceNodes, Map<Integer, List<Integer>> graph, Set<Integer> checked, int target, int distance, int k) {
        if (checked.contains(target)) {
            return;
        }
        
        if (distance == k) {
            distanceNodes.add(target);

            return;
        } else if (distance > k) {
            return;
        }

        checked.add(target);

        for (int node : graph.get(target)) {
            checkOnDistance(distanceNodes, graph, checked, node, distance + 1, k);
        }
    }

    public void bypass(TreeNode root, Map<Integer, List<Integer>> graph) {
        if (root == null) return;

        if (!graph.containsKey(root.val)) {
            graph.put(root.val, new ArrayList<>());
        }

        if (root.left != null) {
            if (!graph.containsKey(root.left.val)) {
                graph.put(root.left.val, new ArrayList<>());
            }

            graph.get(root.val).add(root.left.val);
            graph.get(root.left.val).add(root.val);
            bypass(root.left, graph);
        }

        if (root.right != null) {
            if (!graph.containsKey(root.right.val)) {
                graph.put(root.right.val, new ArrayList<>());
            }

            graph.get(root.val).add(root.right.val);
            graph.get(root.right.val).add(root.val);
            bypass(root.right, graph);
        }
    }
}
