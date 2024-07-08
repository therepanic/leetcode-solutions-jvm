package lowestCommonAncestorOfABinarySearchTree;

import structures.treeNode.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode[] answer = new TreeNode[1];
        helper(root, p, q, answer);

        return answer[0];
    }

    public boolean helper(TreeNode root, TreeNode p, TreeNode q, TreeNode[] answer) {
        boolean leftPathHasCommonAncestor = false;
        boolean rightPathHasCommonAncestor = false;

        if (root.left != null) {
            leftPathHasCommonAncestor = helper(root.left, p, q, answer);
        }

        if (root.right != null) {
            rightPathHasCommonAncestor = helper(root.right, p, q, answer);
        }

        if (!leftPathHasCommonAncestor) {
            if (root.val == q.val || root.val == p.val) {
                leftPathHasCommonAncestor = true;
            }
        } else if (!rightPathHasCommonAncestor){
            if (root.val == q.val || root.val == p.val) {
                rightPathHasCommonAncestor = true;
            }
        }

        if (answer[0] == null && leftPathHasCommonAncestor && rightPathHasCommonAncestor) {
            answer[0] = root;
            return true;
        }

        return leftPathHasCommonAncestor || rightPathHasCommonAncestor;
    }
}
