package kthLargestPerfectSubtreeSizeInBinaryTree;

import structures.treeNode.TreeNode;

import java.util.*;

public class KthLargestPerfectSubtreeSizeInBinaryTree {
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();

        bypass(root, nums);

        nums.sort(Comparator.reverseOrder());

        int kIndex = k - 1;
        return kIndex >= nums.size() ? -1 : nums.get(kIndex);
    }

    public int[] bypass(TreeNode root, List<Integer> nums) {
        int[] left;
        int[] right;

        if (root.left != null) {
            left = bypass(root.left, nums);
        } else {
            left = new int[] {1, 1, 0};
        }

        if (root.right != null) {
            right = bypass(root.right, nums);
        } else {
            right = new int[] {1, 1, 0};
        }

        if (left[0] == left[1] && right[0] == right[1] && left[0] == right[0]) {
            int sum = 1 + left[2] + right[2];

            nums.add(sum);

            return new int[] {left[0] + 1, left[0] + 1, sum};
        } else {
            int max = Math.max(Math.max(left[0], left[1]), Math.max(right[0], right[1])) + 1;
            int min = Math.min(Math.min(left[0], left[1]), Math.min(right[0], right[1])) + 1;

            return new int[] {max, min, 1 + left[2] + right[2]};
        }
    }
}
