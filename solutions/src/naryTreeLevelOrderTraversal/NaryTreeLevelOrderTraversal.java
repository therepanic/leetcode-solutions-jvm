package naryTreeLevelOrderTraversal;

import structures.node.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levelOrders = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> subLevelOrder = new ArrayList<>();
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                subLevelOrder.add(queue.peek().val);

                for (Node node : queue.peek().children) {
                    if (node != null) {
                        queue.add(node);
                    }
                }
                queue.poll();
            }

            levelOrders.add(subLevelOrder);
        }

        return levelOrders;
    }
}
