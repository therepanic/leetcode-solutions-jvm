package printBinaryTree;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        int m = height + 1;
        int n = (int) Math.pow(2, height + 1) - 1;
        List<List<String>> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            answer.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                answer.get(i).add("");
            }
        }
        answer.getFirst().set(n / 2, String.valueOf(root.val));
        bypass(root, answer, height, 0, n / 2);
        return answer;
    }

    private void bypass(TreeNode root, List<List<String>> answer, int height, int r, int c) {
        if (root == null) return;
        if (root.left != null) {
            int newR = r + 1;
            int newC = c - (int) (Math.pow(2, height - r - 1));
            answer.get(newR).set(newC, String.valueOf(root.left.val));
            bypass(root.left, answer, height, newR, newC);
        }
        if (root.right != null) {
            int newR = r + 1;
            int newC = c + (int) (Math.pow(2, height - r - 1));
            answer.get(newR).set(newC, String.valueOf(root.right.val));
            bypass(root.right, answer, height, newR, newC);
        }
    }

    private int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
