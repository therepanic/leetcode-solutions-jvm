package reverseOddLevelsOfBinaryTree;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        int stage = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            if (stage % 2 != 0) {
                List<TreeNode> leftSide = new ArrayList<>();
                List<TreeNode> rightSide = new ArrayList<>();

                for (int i = 0; i < queueSize; i++) {
                    TreeNode node = queue.poll();

                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }

                    if (i < queueSize / 2) {
                        leftSide.add(node);
                    } else {
                        rightSide.add(node);
                    }
                }

                for (int i = 0; i < leftSide.size(); i++) {
                    int buffer = leftSide.get(i).val;

                    leftSide.get(i).val = rightSide.get(leftSide.size() - i - 1).val;
                    rightSide.get(leftSide.size() - i - 1).val = buffer;
                }

                stage++;
                continue;
            }

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            stage++;
        }

        return root;
    }
}
