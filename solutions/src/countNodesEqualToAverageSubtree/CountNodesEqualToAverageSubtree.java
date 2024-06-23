package countNodesEqualToAverageSubtree;

import structures.treeNode.TreeNode;

public class CountNodesEqualToAverageSubtree {
    public int averageOfSubtree(TreeNode root) {
        return helper(root)[2];
    }

    public int[] helper(TreeNode root) {
        int[] left = new int[] {0, 0, 0};
        int[] right = new int[] {0, 0, 0};


        if (root.left == null && root.right == null) {
            return new int[] {root.val, 1, 1};
        }

        if (root.left != null) {
            left = helper(root.left);
        }

        if (root.right != null) {
            right = helper(root.right);
        }


        left[0] += right[0];
        left[0] += root.val;

        left[1] += right[1];
        left[1] += 1;

        left[2] += right[2];

        if (left[0] / left[1] == root.val) {
            left[2] += 1;
        }

        return left;
    }
}
