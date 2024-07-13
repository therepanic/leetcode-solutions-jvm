package maximumLevelSumOfABinaryTree;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxSumStage = 1;

        int currentStage = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            currentStage++;

            int queueSize = queue.size();
            int currentSum = 0;
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.peek();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                currentSum += node.val;
                queue.poll();
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxSumStage = currentStage;
            }
        }

        return maxSumStage;
    }
}
