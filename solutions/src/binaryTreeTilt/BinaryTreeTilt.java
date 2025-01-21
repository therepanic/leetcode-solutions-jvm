package binaryTreeTilt;

import structures.treeNode.TreeNode;

public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        int[] sum = new int[1];
        bypass(root, sum);
        return sum[0];
    }
    public int bypass(TreeNode root, int[] sum) {
        if (root == null) return 0;
        int left = bypass(root.left, sum);
        int right = bypass(root.right, sum);

        sum[0] += Math.abs(left - right);
        return left + right + root.val;
    }
}
