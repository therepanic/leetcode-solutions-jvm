package findBottomLeftTreeValue;

import structures.treeNode.TreeNode;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int[] helper = new int[2];

        helper(root, helper, 0);

        return helper[0];
    }

    public void helper(TreeNode root, int[] helper, int stage) {
        if (stage >= helper[1]) {
            helper[0] = root.val;
            helper[1] = stage;
        }

        if (root.right != null) {
            helper(root.right, helper, stage + 1);
        }

        if (root.left != null) {
            helper(root.left, helper, stage + 1);
        }
    }
}
