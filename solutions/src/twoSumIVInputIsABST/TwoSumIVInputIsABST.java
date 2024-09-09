package twoSumIVInputIsABST;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();

        bypass(root, nums);

        int l = 0;
        int r = nums.size() - 1;

        while (l <   r) {
            int sum = nums.get(l) + nums.get(r);

            if (sum == k) {
                return true;
            } else if (sum > k) {
                r--;
            } else {
                l++;
            }
        }

        return false;
    }

    public void bypass(TreeNode root, List<Integer> nums) {
        if (root == null) return;

        bypass(root.left, nums);

        nums.add(root.val);

        bypass(root.right, nums);
    }
}
