package diameterOfBinaryTree;

import structures.treeNode.TreeNode;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] mostDiameter = new int[1];
        helper(root, mostDiameter);

        return mostDiameter[0];
    }

    public int helper(TreeNode root, int[] mostDiameter) {
        int leftPathDiameter = 0;
        int rightPathDiameter = 0;

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left != null) {
            leftPathDiameter = helper(root.left, mostDiameter);
        }

        if (root.right != null) {
            rightPathDiameter = helper(root.right, mostDiameter);
        }

        mostDiameter[0] = Math.max(mostDiameter[0], leftPathDiameter + rightPathDiameter);

        return Math.max(leftPathDiameter + 1, rightPathDiameter + 1);
    }
}
