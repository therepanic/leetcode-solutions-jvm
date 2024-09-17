package distributeCoinsInBinaryTree;

import structures.treeNode.TreeNode;

public class DistributeCoinsInBinaryTree {
    public int distributeCoins(TreeNode root) {
        int[] answer = new int[1];

        bypass(root, answer);
        return answer[0];
    }

    public int bypass(TreeNode root, int[] answer) {
        if (root == null) return 0;

        int left = bypass(root.left, answer);
        int right = bypass(root.right, answer);

        int result = root.val + left + right - 1;

        answer[0] += Math.abs(result);

        return result;
    }
}
