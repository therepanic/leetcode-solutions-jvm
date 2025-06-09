package univaluedBinaryTree;

import structures.treeNode.TreeNode;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        return helper(root, root.val);
    }

    public boolean helper(TreeNode root, int node) {
        if (root.val != node) {
            return false;
        }
        if (root.left != null && !helper(root.left, node)) {
            return false;
        }
        return root.right == null || helper(root.right, node);
    }
}
