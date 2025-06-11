package evaluateBooleanBinaryTree;

import structures.treeNode.TreeNode;

public class EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val != 0;
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = evaluateTree(root.left);
        }
        if (root.right != null) {
            right = evaluateTree(root.right);
        }
        return root.val == 2 ? (left || right) : (left && right);
    }
}
