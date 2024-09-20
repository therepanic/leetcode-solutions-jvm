package maximumProductOfSplittedBinaryTree;

import structures.treeNode.TreeNode;

public class MaximumProductOfSplittedBinaryTree {
    public int maxProduct(TreeNode root) {
        int maxSum = sum(root);

        long[] answer = new long[1];

        bypass(root, answer, maxSum);

        return (int) (answer[0] % 1000000007);
    }

    public int bypass(TreeNode root, long[] answer, int maxSum) {
        if (root == null) return 0;

        int left = bypass(root.left, answer, maxSum);
        int right = bypass(root.right, answer, maxSum);

        answer[0] = Math.max(answer[0], (long) (maxSum - left) * left);
        answer[0] = Math.max(answer[0], (long) (maxSum - right) * right);

        return root.val + left + right;
    }


    public int sum(TreeNode root) {
        if (root == null) return 0;

        return root.val + sum(root.left) + sum(root.right);
    }
}
