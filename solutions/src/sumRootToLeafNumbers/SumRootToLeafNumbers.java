package sumRootToLeafNumbers;

import structures.treeNode.TreeNode;


public class SumRootToLeafNumbers {
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, "");

        return sum;
    }

    public void helper(TreeNode root, String actualNumber) {
        actualNumber += root.val;

        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(actualNumber);
        }

        if (root.left != null) {
            helper(root.left, actualNumber);
        }

        if (root.right != null) {
            helper(root.right, actualNumber);
        }
    }
}
