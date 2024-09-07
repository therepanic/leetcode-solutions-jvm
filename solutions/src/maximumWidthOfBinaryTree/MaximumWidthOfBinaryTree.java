package maximumWidthOfBinaryTree;

import structures.treeNode.TreeNode;

import java.util.*;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        TreeNode indexedTree = new TreeNode(0);

        bypassAndFillIndexedTree(root, indexedTree);

        Deque<TreeNode> deque = new ArrayDeque<>(List.of(indexedTree));

        int maxWidth = 0;

        while (!deque.isEmpty()) {
            int dequeSize = deque.size();

            maxWidth = Math.max(maxWidth, deque.getLast().val - deque.getFirst().val + 1);

            for (int i = 0; i < dequeSize; i++) {
                TreeNode node = deque.pollFirst();

                if (node.left != null) {
                    deque.add(node.left);
                }

                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }

        return maxWidth;
    }

    public void bypassAndFillIndexedTree(TreeNode root, TreeNode indexedTree) {
        if (root == null) return;

        if (root.left != null) {
            indexedTree.left = new TreeNode(indexedTree.val * 2);
            bypassAndFillIndexedTree(root.left, indexedTree.left);
        }

        if (root.right != null) {
            indexedTree.right = new TreeNode(indexedTree.val * 2 + 1);
            bypassAndFillIndexedTree(root.right, indexedTree.right);
        }
    }
}
