import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return helper(new ArrayList<>(), root);
    }

    public List<Integer> helper(List<Integer> nums, TreeNode root) {
        if (root.left != null) {
            helper(nums, root.left);
        }

        nums.add(root.val);

        if (root.right != null) {
            helper(nums, root.right);
        }

        return nums;
    }
}
