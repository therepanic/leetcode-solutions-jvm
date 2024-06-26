package deleteNodeInABst;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodeInABst {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        List<Integer> nodeValues = new ArrayList<>();

        read(root, nodeValues);

        nodeValues.remove(Integer.valueOf(key));

        if (nodeValues.isEmpty()) {
            return null;
        }

        TreeNode newTreeNode = new TreeNode();

        helper(newTreeNode, nodeValues);

        return newTreeNode;
    }

    public static void helper(TreeNode root, List<Integer> nodeValues) {
        int middle = nodeValues.size() / 2;

        root.val = nodeValues.get(middle);

        List<Integer> left = nodeValues.subList(0, nodeValues.size() / 2);
        List<Integer> right = nodeValues.subList(nodeValues.size() / 2 + 1, nodeValues.size());

        if (!left.isEmpty()) {
            root.left = new TreeNode();
            helper(root.left, left);
        }

        if (!right.isEmpty()) {
            root.right = new TreeNode();
            helper(root.right, right);
        }
    }

    public static void read(TreeNode root, List<Integer> nodeValues) {
        if (root.left != null) {
            read(root.left, nodeValues);
        }

        nodeValues.add(root.val);

        if (root.right != null) {
            read(root.right, nodeValues);
        }
    }
}
