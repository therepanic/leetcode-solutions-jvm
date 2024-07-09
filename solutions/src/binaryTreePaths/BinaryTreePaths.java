package binaryTreePaths;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> values = new ArrayList<>();

        helper(root, values, "");

        return values;
    }

    public void helper(TreeNode root, List<String> values, String path) {
        if (path.isEmpty()) {
            path += root.val;
        } else {
            path += "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            values.add(path);
        }

        if (root.left != null) {
            helper(root.left, values, path);
        }

        if (root.right != null) {
            helper(root.right, values, path);
        }
    }
}
