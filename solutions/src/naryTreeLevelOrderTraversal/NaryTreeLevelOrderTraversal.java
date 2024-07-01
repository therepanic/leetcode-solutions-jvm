package naryTreeLevelOrderTraversal;

import structures.nTreeNode.NTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(NTreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levelOrders = new ArrayList<>();
        Queue<NTreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> subLevelOrder = new ArrayList<>();
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                subLevelOrder.add(queue.peek().val);

                for (NTreeNode NTreeNode : queue.peek().children) {
                    if (NTreeNode != null) {
                        queue.add(NTreeNode);
                    }
                }
                queue.poll();
            }

            levelOrders.add(subLevelOrder);
        }

        return levelOrders;
    }
}
