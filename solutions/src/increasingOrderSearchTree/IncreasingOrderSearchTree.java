package increasingOrderSearchTree;

import structures.treeNode.TreeNode;

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode node = new TreeNode(-1);
        TreeNode[] nodeArr = new TreeNode[] {node};
        helper(root, nodeArr);
        return node.right;
    }

    public void helper(TreeNode root, TreeNode[] dummy) {
        if (root == null) return;
        helper(root.left, dummy);
        dummy[0].right = new TreeNode(root.val);
        dummy[0] = dummy[0].right;
        helper(root.right, dummy);
    }
}
