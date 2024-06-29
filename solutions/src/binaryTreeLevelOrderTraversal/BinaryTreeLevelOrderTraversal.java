package binaryTreeLevelOrderTraversal;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levelOrders = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> subLevelOrders = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                subLevelOrders.add(queue.peek().val);

                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }

                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }

                queue.poll();
            }

            levelOrders.add(subLevelOrders);
        }

        return levelOrders;
    }
}
