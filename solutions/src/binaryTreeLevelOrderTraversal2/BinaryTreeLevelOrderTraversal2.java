package binaryTreeLevelOrderTraversal2;

import structures.treeNode.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        for (int i = 0; i < levelOrders.size() / 2; i++) {
            List<Integer> buffer = levelOrders.get(i);

            levelOrders.set(i, levelOrders.get(levelOrders.size() - i - 1));
            levelOrders.set(levelOrders.size() - i - 1, buffer);
        }

        return levelOrders;
    }
}
