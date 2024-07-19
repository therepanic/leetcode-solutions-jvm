package averageOfLevelsInBinaryTree;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageOfLevels = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            long sumOfLevel = 0;
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.peek();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                sumOfLevel += node.val;
                queue.poll();
            }

            averageOfLevels.add((double) sumOfLevel / queueSize);
        }

        return averageOfLevels;
    }
}
