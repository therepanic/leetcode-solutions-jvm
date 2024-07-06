package binaryTreeRightSideView;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> rightSideViewTreeNode = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.add(root);

        while (!deque.isEmpty()) {
            int dequeSize = deque.size();

            rightSideViewTreeNode.add(deque.getLast().val);

            for (int i = 0; i < dequeSize; i++) {
                TreeNode node = deque.peekFirst();

                if (node.left != null) {
                    deque.add(node.left);
                }

                if (node.right != null) {
                    deque.add(node.right);
                }

                deque.removeFirst();
            }
        }

        return rightSideViewTreeNode;
    }
}
