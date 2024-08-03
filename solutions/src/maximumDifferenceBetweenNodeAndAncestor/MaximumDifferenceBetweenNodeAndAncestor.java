package maximumDifferenceBetweenNodeAndAncestor;

import structures.treeNode.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public int helper(TreeNode root, int min, int max) {
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        int diff = Math.abs(min - max);

        int left = -1;
        int right = -1;

        if (root.left != null) {
            left = helper(root.left, min, max);
        }

        if (root.right != null) {
            right = helper(root.right, min, max);
        }

        return Math.max(diff, Math.max(left, right));
    }
}
