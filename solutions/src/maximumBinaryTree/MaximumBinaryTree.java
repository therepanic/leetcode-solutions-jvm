package maximumBinaryTree;

import structures.treeNode.TreeNode;

import java.util.Arrays;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int maxValue = -1;
        int maxValueIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }

        TreeNode newTreeNode = new TreeNode(maxValue);

        int[] leftNums = Arrays.copyOfRange(nums, 0, maxValueIndex);
        int[] rightNums = Arrays.copyOfRange(nums, maxValueIndex + 1, nums.length);

        if (leftNums.length >= 1) {
            newTreeNode.left = constructMaximumBinaryTree(leftNums);
        }

        if (rightNums.length >= 1) {
            newTreeNode.right = constructMaximumBinaryTree(rightNums);
        }

        return newTreeNode;
    }
}
