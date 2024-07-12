package kthLargestSumInABinaryTree;

import structures.treeNode.TreeNode;

import java.util.*;

public class KthLargestSumInABinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSums = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            long sum = 0;

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.peek();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                sum += node.val;
                queue.poll();
            }

            levelSums.add(sum);
        }

        Collections.sort(levelSums);

        if (k > levelSums.size()) {
            return levelSums.get(0);
        }

        return levelSums.get(levelSums.size() - k + 1);
    }
}
