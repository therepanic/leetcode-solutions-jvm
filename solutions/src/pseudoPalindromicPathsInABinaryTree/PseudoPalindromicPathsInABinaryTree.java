package pseudoPalindromicPathsInABinaryTree;

import structures.treeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromicPathsInABinaryTree {
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] answer = new int[1];
        bypass(root, new int[9], answer);
        return answer[0];
    }
    public void bypass(TreeNode root, int[] count, int[] answer) {
        int index = root.val - 1;

        count[index]++;

        if (root.left != null) {
            bypass(root.left, count, answer);
        }

        if (root.right != null) {
            bypass(root.right, count, answer);
        }

        if (root.left == null && root.right == null) {
            boolean isOk = true;
            int countNon = 0;

            for (int i = 0; i < 9; i++) {
                if (count[i] % 2 != 0) {
                    countNon++;
                }

                if (countNon > 1) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                answer[0]++;
            }
        }

        count[index]--;
    }
}
