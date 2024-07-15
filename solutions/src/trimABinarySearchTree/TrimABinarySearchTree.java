package trimABinarySearchTree;

import structures.treeNode.TreeNode;

public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        if (root.left != null) {
            root.left = trimBST(root.left, low, high);
        }

        if (root.right != null) {
            root.right = trimBST(root.right, low, high);
        }

        return root;
    }
}
