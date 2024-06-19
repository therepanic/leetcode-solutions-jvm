package binaryTreeMaximumPathSum;

import structures.treeNode.TreeNode;

public class BinaryTreeMaximumPathSum {
    int answer = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root);

        return answer;
    }

    public int helper(TreeNode root) {
        int leftCorrectPathSum = 0;
        int rightCorrectPathSum = 0;

        if (root.left != null) {
            leftCorrectPathSum = Math.max(helper(root.left), 0);
        }

        if (root.right != null) {
            rightCorrectPathSum = Math.max(helper(root.right), 0);
        }

        if (leftCorrectPathSum + rightCorrectPathSum + root.val > answer) {
            answer = leftCorrectPathSum + rightCorrectPathSum + root.val;
        }

        return Math.max(leftCorrectPathSum, rightCorrectPathSum) + root.val;
    }
}
