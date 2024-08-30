package findElementsInAContaminatedBinaryTree;

import structures.treeNode.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElements {
    private final Set<Integer> elements;

    public FindElements(TreeNode root) {
        root.val = 0;

        Set<Integer> elements = new HashSet<>(Set.of(0));

        helper(root, elements);

        this.elements = elements;
    }

    public boolean find(int target) {
        return elements.contains(target);
    }

    private void helper(TreeNode root, Set<Integer> set) {
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;

            set.add(root.left.val);
            helper(root.left, set);
        }

        if (root.right != null) {
            root.right.val = 2 * root.val + 2;

            set.add(root.right.val);
            helper(root.right, set);
        }
    }
}
