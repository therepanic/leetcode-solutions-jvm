package rangeSumOfBST;

import structures.treeNode.TreeNode;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] mutableSum = new int[1];

        helper(root, low, high, mutableSum);

        return mutableSum[0];
    }

    public void helper(TreeNode root, int low, int high, int[] mutableSum) {
        if (root.val > low || root.val < high) {
            mutableSum[0] += root.val;
        }

        if (root.left != null && root.val > low) {
            helper(root.left, low, high, mutableSum);
        }

        if (root.right != null && root.val < high) {
            helper(root.right, low, high, mutableSum);
        }
    }
}
