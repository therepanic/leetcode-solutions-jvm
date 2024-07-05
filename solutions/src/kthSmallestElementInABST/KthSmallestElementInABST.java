package kthSmallestElementInABST;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        List<Integer> values = new ArrayList<>();

        read(root, values);

        return values.get(k - 1);
    }

    public void read(TreeNode root, List<Integer> values) {
        if (root.left != null) {
            read(root.left, values);
        }

        values.add(root.val);

        if (root.right != null) {
            read(root.right, values);
        }
    }
}
