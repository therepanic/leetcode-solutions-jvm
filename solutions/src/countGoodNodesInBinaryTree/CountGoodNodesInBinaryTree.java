package countGoodNodesInBinaryTree;

import structures.treeNode.TreeNode;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        int[] countGoodNodes = new int[1];

        helper(root, root.val, countGoodNodes);

        return countGoodNodes[0];
    }

    public void helper(TreeNode root, int mostValue, int[] countGoodNodes) {
        if (mostValue <= root.val) {
            countGoodNodes[0]++;
        }

        if (root.left != null) {
            helper(root.left, Math.max(root.val, mostValue), countGoodNodes);
        }

        if (root.right != null) {
            helper(root.right, Math.max(root.val, mostValue), countGoodNodes);
        }
    }
}
