package leafSimilarTrees;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = new ArrayList<>();
        List<Integer> root2List = new ArrayList<>();

        check(root1, root1List);
        check(root2, root2List);

        return root1List.equals(root2List);
    }

    public void check(TreeNode root, List<Integer> values) {
        if (root.left != null) {
            check(root.left, values);
        }

        if (root.right != null) {
            check(root.right, values);
        }

        if (root.left == null && root.right == null) {
            values.add(root.val);
        }
    }
}
