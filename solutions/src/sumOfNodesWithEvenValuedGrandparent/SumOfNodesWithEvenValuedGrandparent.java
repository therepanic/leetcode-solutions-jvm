package sumOfNodesWithEvenValuedGrandparent;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumOfNodesWithEvenValuedGrandparent {
    public static int sumEvenGrandparent(TreeNode root) {
        int[] answer = new int[1];

        helper(root, new ArrayList<>(), answer);

        return answer[0];
    }

    public static void helper(TreeNode root, List<Integer> steps, int[] answer) {
        steps.add(root.val);

        if (steps.size() >= 3) {
            if (steps.get(steps.size() - 3) % 2 == 0) {
                answer[0] += root.val;
            }
        }

        if (root.left != null) {
            helper(root.left, steps, answer);
        }

        if (root.right != null) {
            helper(root.right, steps, answer);
        }

        steps.remove(steps.size() - 1);
    }
}
