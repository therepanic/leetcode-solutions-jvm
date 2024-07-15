package linkedListInBinaryTree;

import structures.listNode.ListNode;
import structures.treeNode.TreeNode;

public class LinkedListInBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root.val == head.val && helper(head, root)) {
            return true;
        }

        boolean leftPath = false;
        boolean rightPath = false;

        if (root.left != null) {
            leftPath = isSubPath(head, root.left);
        }

        if (root.right != null) {
            rightPath = isSubPath(head, root.right);
        }

        return leftPath || rightPath;
    }

    public boolean helper(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (head.val != root.val) {
            return false;
        }

        head = head.next;

        if (head == null) {
            return true;
        }

        boolean leftPath = false;
        boolean rightPath = false;

        if (root.left != null) {
            leftPath = helper(head, root.left);
        }

        if (root.right != null) {
            rightPath = helper(head, root.right);
        }

        return leftPath || rightPath;
    }
}
