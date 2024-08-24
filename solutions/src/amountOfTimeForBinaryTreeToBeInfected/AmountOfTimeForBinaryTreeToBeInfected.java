package amountOfTimeForBinaryTreeToBeInfected;

import structures.treeNode.TreeNode;

import java.util.*;

public class AmountOfTimeForBinaryTreeToBeInfected {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> reversedGraph = new HashMap<>();

        helper(root, graph, reversedGraph);

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(start);

        int minute = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                int node = queue.poll();


                if (graph.containsKey(node)) {
                    queue.addAll(graph.get(node));

                    for (int value : graph.get(node)) {
                        reversedGraph.get(value).remove(Integer.valueOf(node));
                    }
                }

                if (reversedGraph.containsKey(node)) {
                    queue.addAll(reversedGraph.get(node));

                    for (int value : reversedGraph.get(node)) {
                        graph.get(value).remove(Integer.valueOf(node));
                    }
                }
            }

            minute++;
        }

        return minute;
    }
    public void helper(TreeNode root, Map<Integer, List<Integer>> graph, Map<Integer, List<Integer>> reversedGraph) {
        if (!graph.containsKey(root.val)) {
            graph.put(root.val, new ArrayList<>());
        }

        if (!reversedGraph.containsKey(root.val)) {
            reversedGraph.put(root.val, new ArrayList<>());
        }


        if (root.left != null) {
            if (!reversedGraph.containsKey(root.left.val)) {
                reversedGraph.put(root.left.val, new ArrayList<>());
            }

            graph.get(root.val).add(root.left.val);

            reversedGraph.get(root.left.val).add(root.val);
        }

        if (root.right != null) {
            if (!reversedGraph.containsKey(root.right.val)) {
                reversedGraph.put(root.right.val, new ArrayList<>());
            }

            graph.get(root.val).add(root.right.val);

            reversedGraph.get(root.right.val).add(root.val);
        }

        if (root.left != null) {
            helper(root.left, graph, reversedGraph);
        }

        if (root.right != null) {
            helper(root.right, graph, reversedGraph);
        }
    }
}
