package flipEquivalentBinaryTrees;

import structures.treeNode.TreeNode;

public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null && root1.val == root2.val) {
            boolean left;
            boolean right;

            left = flipEquiv(root1.left, root2.left);
            right = flipEquiv(root1.right, root2.right);

            if (!(left && right)) {
                flip(root1);

                left = flipEquiv(root1.left, root2.left);
                right = flipEquiv(root1.right, root2.right);

                return left && right;
            }

        } else return root1 == null && root2 == null;

        return true;
    }

    public void flip(TreeNode root) {
        if (root == null) return;

        TreeNode buffer = root.left;

        root.left = root.right;
        root.right = buffer;

        flip(root.left);
        flip(root.right);
    }
}
