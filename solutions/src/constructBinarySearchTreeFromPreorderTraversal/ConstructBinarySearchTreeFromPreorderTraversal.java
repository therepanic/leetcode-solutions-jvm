package constructBinarySearchTreeFromPreorderTraversal;

import structures.treeNode.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode node = null;

        for (int value : preorder) {
            node = helper(node, value);
        }

        return node;
    }
    public TreeNode helper(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value > root.val) {
            root.right = helper(root.right, value);
        } else {
            root.left = helper(root.left, value);
        }

        return root;
    }
}
