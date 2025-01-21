package secondMinimumNodeInABinaryTree;

import structures.treeNode.TreeNode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        bypass(root, set);

        if (set.size() < 2) {
            return -1;
        } else {
            set.pollFirst();
            return set.pollFirst();
        }
    }

    public void bypass(TreeNode root, TreeSet<Integer> set) {
        if (root == null) return;
        set.add(root.val);
        bypass(root.left, set);
        bypass(root.right, set);
    }
}
