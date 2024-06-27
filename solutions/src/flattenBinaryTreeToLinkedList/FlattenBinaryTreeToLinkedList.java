package flattenBinaryTreeToLinkedList;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        helper(queue, root);

        int queueSize = queue.size();
        int i = 0;
        TreeNode dummy = root;
        while (!queue.isEmpty()) {
            dummy.val = queue.poll();

            if (dummy.right == null && i != queueSize - 1) {
                dummy.right = new TreeNode();
            }

            dummy.left = null;
            dummy = dummy.right;
            i++;
        }
    }

    public static void helper(Queue<Integer> queue, TreeNode root) {
        queue.add(root.val);

        if (root.left != null) {
            helper(queue, root.left);
        }

        if (root.right != null) {
            helper(queue, root.right);
        }
    }
}
