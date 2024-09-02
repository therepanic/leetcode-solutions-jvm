package binaryTreePruning;

import structures.treeNode.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (!checkOnContainsOne(root)) {
            return null;
        }

        if (root.left != null) {
            root.left = pruneTree(root.left);
        }

        if (root.right != null) {
            root.right = pruneTree(root.right);
        }

        return root;
    }

    public boolean checkOnContainsOne(TreeNode root) {
        if (root == null) return false;
        if (root.val == 1) return true;


        boolean left = checkOnContainsOne(root.left);

        if (left) {
            return true;
        }

        return checkOnContainsOne(root.right);
    }
}
