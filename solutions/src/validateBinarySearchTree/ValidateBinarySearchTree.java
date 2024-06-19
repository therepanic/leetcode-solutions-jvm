package validateBinarySearchTree;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        helper(nodes, root);

        List<Integer> sortedNodesValues = new ArrayList<>();
        for (TreeNode node : nodes) {
            sortedNodesValues.add(node.val);
        }
        Collections.sort(sortedNodesValues);

        for (int i = 0; i < sortedNodesValues.size() - 1; i++) {
            if (sortedNodesValues.get(i).equals(sortedNodesValues.get(i + 1))) {
                return false;
            }
        }

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).val != sortedNodesValues.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void helper(List<TreeNode> nums, TreeNode root) {
        if (root.left != null) {
            helper(nums, root.left);
        }

        nums.add(root);

        if (root.right != null) {
            helper(nums, root.right);
        }
    }
}
