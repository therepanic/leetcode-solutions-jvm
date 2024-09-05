package checkCompletenessOfABinaryTree;

import structures.treeNode.TreeNode;

import java.util.*;

public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        boolean switcher = false;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();

                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }

                if (node == null) {
                    switcher = true;
                } else if (switcher) {
                    return false;
                }
            }
        }

        return true;
    }
}
