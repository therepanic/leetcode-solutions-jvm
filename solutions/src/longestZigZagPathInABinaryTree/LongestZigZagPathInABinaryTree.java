package longestZigZagPathInABinaryTree;

import structures.treeNode.TreeNode;

public class LongestZigZagPathInABinaryTree {
    public int longestZigZag(TreeNode root) {
        int[] answer = new int[1];

        bypass(root, 0, 0, answer);

        return answer[0];
    }

    public void bypass(TreeNode root, int l, int r, int[] answer) {
        if (root == null) return;

        answer[0] = Math.max(answer[0], l + r);

        bypass(root.left, r + 1, 0, answer);
        bypass(root.right, 0, l + 1, answer);
    }
}
