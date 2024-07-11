package binarySearchTreeIterator;

import structures.treeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BSTIterator {
    private List<Integer> values = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        bypassInorder(root);
    }

    public int next() {
        int value = values.get(0);

        values.remove(0);

        return value;
    }

    public boolean hasNext() {
        return !values.isEmpty();
    }

    private void bypassInorder(TreeNode root) {
        if (root.left != null) {
            bypassInorder(root.left);
        }

        values.add(root.val);

        if (root.right != null) {
            bypassInorder(root.right);
        }
    }
}
