package cousinsInBinaryTree;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (bypass(root, x, y)) {
            return false;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int qSize = queue.size();

            boolean hasX = false;
            boolean hasY = false;

            for (int i = 0; i < qSize; i++) {
                TreeNode node = queue.poll();
                if (node.val == x) {
                    hasX = true;
                } else if (node.val == y) {
                    hasY = true;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (hasX && hasY) {
                return true;
            }
        }
        return false;
    }

    public boolean bypass(TreeNode root, int x, int y) {
        if (root == null) return false;

        if (root.left != null && root.right != null && (root.left.val == x && root.right.val == y || root.left.val == y && root.right.val == x)) {
            return true;
        }

        return bypass(root.left, x, y) || bypass(root.right, x, y);
    }
}
