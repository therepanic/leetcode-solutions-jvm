package countDominantNodesInABinaryTree;

import structures.treeNode.TreeNode;

public class CountDominantNodesInABinaryTree {
    public int countDominantNodes(TreeNode root) {
        int[] ans = new int[1];
        helper(root, ans);
        return ans[0];
    }

    public int helper(TreeNode root, int[] count) {
        if (root.left == null && root.right == null) {
            count[0]++;
            return root.val;
        }
        int a = -1;
        if (root.left != null) {
            a = helper(root.left, count);
        }
        int b = -1;
        if (root.right != null) {
            b = helper(root.right, count);
        }
        int max = Math.max(a, Math.max(b, root.val));
        if (max == root.val) {
            count[0]++;
        }
        return max;
    }
}
