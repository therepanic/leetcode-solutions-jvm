package subtreeOfAnotherTree;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }

        return helper(root, subRoot);
    }
    public boolean helper(TreeNode root, TreeNode subRoot) {
        boolean isLeftPathHasSubtree = false;
        boolean isRightPathHasSubtree = false;

        if (root.left != null) {
            isLeftPathHasSubtree = helper(root.left, subRoot);
        }

        if (root.right != null) {
            isRightPathHasSubtree = helper(root.right, subRoot);
        }

        if (isLeftPathHasSubtree || isRightPathHasSubtree) {
            return true;
        }

        if (root.val == subRoot.val) {
            return isSameTree(root, subRoot);
        }

        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();

            if (first != null && second != null && first.val == second.val) {
                if (first.left != null && second.left != null) {
                    queue.add(first.left);
                    queue.add(second.left);
                } else if (first.left != null || second.left != null){
                    return false;
                }

                if (first.right != null && second.right != null) {
                    queue.add(first.right);
                    queue.add(second.right);
                } else if (first.right != null || second.right != null){
                    return false;
                }

            } else {
                return false;
            }
        }
        return true;
    }
}
