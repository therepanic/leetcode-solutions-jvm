package binarySearchTreeToGreaterSumTree;

import structures.treeNode.TreeNode;

public class BinarySearchTreeToGreaterSumTree {
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        helper(root, 0);

        return root;
    }

    public int helper(TreeNode root, int sum) {
        if (root.right != null) {
            root.val += helper(root.right, sum);
        } else {
            root.val += sum;
        }

        if (root.left != null) {
            return helper(root.left, root.val);
        }

        return root.val;
    }
}
