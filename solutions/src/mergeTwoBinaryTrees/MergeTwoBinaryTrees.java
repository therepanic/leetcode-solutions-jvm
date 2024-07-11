package mergeTwoBinaryTrees;

import structures.treeNode.TreeNode;

public class MergeTwoBinaryTrees {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            if (root1 != null) {
                return root1;
            } else {
                return root2;
            }
        } else {
            root1.val += root2.val;
        }

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}
