package flipBinaryTreeToMatchPreorderTraversal;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root.val != voyage[0]) {
            return List.of(-1);
        }
        List<Integer> correctVoyage = new ArrayList<>();

        boolean[] isImpossible = new boolean[1];

        bypass(root, null, false, correctVoyage, voyage, 0, isImpossible);

        if (isImpossible[0]) {
            return List.of(-1);
        }

        return correctVoyage;
    }

    public int bypass(TreeNode root, TreeNode prev, boolean isLeft, List<Integer> correctVoyage, int[] voyage, int index, boolean[] isImpossible) {
        if (root == null) return index - 1;

        if (voyage[index] != root.val) {
            flip(prev);

            if (isLeft) {
                root = prev.left;
            } else {
                root = prev.right;

            }
            if (root == null || voyage[index] != root.val) {
                isImpossible[0] = true;
                correctVoyage.add(-1);
                return 0;
            }

            correctVoyage.add(prev.val);
        }

        index = bypass(root.left, root, true, correctVoyage, voyage, index + 1, isImpossible);

        if (isImpossible[0]) {
            return 0;
        }

        index = bypass(root. right, root, false, correctVoyage, voyage, index + 1, isImpossible);

        if (isImpossible[0]) {
            return 0;
        }

        return index;
    }

    public void flip(TreeNode root) {
        if (root == null) return;

        TreeNode buffer = root.left;

        root.left = root.right;
        root.right = buffer;
    }
}
