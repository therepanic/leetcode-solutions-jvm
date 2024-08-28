package longestUnivaluePath;

import structures.treeNode.TreeNode;

public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] answer = new int[] {Integer.MIN_VALUE};

        helper(root, Integer.MIN_VALUE + 1, answer);

        return answer[0];
    }

    public int helper(TreeNode root, int prevValue, int[] answer) {
        int left = 0;
        int right = 0;

        if (root.left != null) {
            left += helper(root.left, root.val, answer);
        }

        if (root.right != null) {
            right += helper(root.right, root.val, answer);
        }

        answer[0] = Math.max(left + right, answer[0]);

        if (prevValue != root.val) {
            return 0;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
