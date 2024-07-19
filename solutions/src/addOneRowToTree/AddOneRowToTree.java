package addOneRowToTree;

import structures.treeNode.TreeNode;

public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        return helper(root, val, depth, 1);
    }

    public TreeNode helper(TreeNode root, int val, int depth, int currentDepth) {
        if (currentDepth + 1 == depth) {
            TreeNode newNodeLeft = new TreeNode(val, root.left, null);
            TreeNode newNodeRight = new TreeNode(val, null, root.right);

            root.left = newNodeLeft;
            root.right = newNodeRight;

            return root;
        }

        if (root.left != null) {
            root.left = helper(root.left, val, depth, currentDepth + 1);
        }

        if (root.right != null) {
            root.right = helper(root.right, val, depth, currentDepth + 1);
        }

        return root;
    }
}
