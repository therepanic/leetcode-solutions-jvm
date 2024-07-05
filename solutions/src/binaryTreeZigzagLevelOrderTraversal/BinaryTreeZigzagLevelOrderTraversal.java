package binaryTreeZigzagLevelOrderTraversal;

import structures.treeNode.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> zigzagLevelOrder = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        boolean isActive = false;

        while (!queue.isEmpty()) {
            List<Integer> subZigzagLevelOrder = new ArrayList<>();
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.peek();

                subZigzagLevelOrder.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                queue.poll();
            }

            if (isActive) {
                Collections.reverse(subZigzagLevelOrder);
            }

            zigzagLevelOrder.add(subZigzagLevelOrder);

            isActive = !isActive;
        }

        return zigzagLevelOrder;
    }
}
