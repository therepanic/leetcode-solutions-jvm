package allElementsInTwoBinarySearchTrees;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();

        helper(list, root1);
        helper(list, root2);

        Collections.sort(list);

        return list;
    }

    public void helper(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        list.add(root.val);

        if (root.left != null) {
            helper(list, root.left);
        }

        if (root.right != null) {
            helper(list, root.right);
        }
    }
}
