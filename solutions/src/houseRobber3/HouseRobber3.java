package houseRobber3;

import structures.treeNode.TreeNode;

public class HouseRobber3 {
    public int rob(TreeNode root) {
        int[] variants = helper(root);

        return Math.max(variants[0], variants[1]);
    }

    public int[] helper(TreeNode root) {
        int[] leftPathSum = new int[] {0, 0};
        int[] rightPathSum = new int[] {0, 0};

        if (root.left != null) {
            leftPathSum = helper(root.left);
        }

        if (root.right != null) {
            rightPathSum = helper(root.right);
        }

        int grab = leftPathSum[0] + rightPathSum[0] + root.val;
        int noGrab = Math.max(leftPathSum[0], leftPathSum[1]) + Math.max(rightPathSum[0], rightPathSum[1]);

        return new int[] {noGrab, grab};
    }
}
