package recoverBinarySearchTree;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        helper(nodes, root);

        List<Integer> sortedNodesValues = new ArrayList<>();
        for (TreeNode node : nodes) {
            sortedNodesValues.add(node.val);
        }
        Collections.sort(sortedNodesValues);

        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).val = sortedNodesValues.get(i);
        }
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