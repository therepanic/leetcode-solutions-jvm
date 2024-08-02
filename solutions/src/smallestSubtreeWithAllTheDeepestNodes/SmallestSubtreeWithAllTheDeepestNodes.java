package smallestSubtreeWithAllTheDeepestNodes;

import structures.treeNode.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }

        return helper(root);
    }

    public int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxPath(root.left), maxPath(root.right));
    }

    public TreeNode helper(TreeNode root) {
        int leftMaxPath = maxPath(root.left);
        int rightMaxPath = maxPath(root.right);

        if (leftMaxPath == rightMaxPath) {
            return root;
        } else if (leftMaxPath > rightMaxPath) {
            return helper(root.left);
        } else {
            return helper(root.right);
        }
    }
}
