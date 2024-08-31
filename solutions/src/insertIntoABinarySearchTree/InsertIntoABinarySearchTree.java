package insertIntoABinarySearchTree;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        List<Integer> values = new ArrayList<>();

        helper1(root, values);

        values.add(val);

        Collections.sort(values);

        return createBST(values);
    }

    public TreeNode createBST(List<Integer> values) {
        if (values.isEmpty()) return null;

        TreeNode newNode = new TreeNode(values.get(values.size() / 2));

        List<Integer> left = values.subList(0, values.size() / 2);
        List<Integer> right = values.subList(values.size() / 2 + 1, values.size());

        newNode.left = createBST(left);
        newNode.right = createBST(right);

        return newNode;
    }

    public void helper1(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        helper1(root.left, values);

        values.add(root.val);

        helper1(root.right, values);
    }
}
