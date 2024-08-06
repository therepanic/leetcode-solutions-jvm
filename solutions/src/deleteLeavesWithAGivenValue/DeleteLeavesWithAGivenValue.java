package deleteLeavesWithAGivenValue;

import structures.treeNode.TreeNode;

public class DeleteLeavesWithAGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null) {
            root.left = removeLeafNodes(root.left, target);
        }

        if (root.right != null) {
            root.right = removeLeafNodes(root.right, target);
        }

        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
