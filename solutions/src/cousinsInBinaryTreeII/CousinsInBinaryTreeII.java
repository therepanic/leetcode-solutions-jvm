package cousinsInBinaryTreeII;

import structures.treeNode.TreeNode;

import java.util.*;

public class CousinsInBinaryTreeII {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        List<Integer> stageSums = new ArrayList<>();

        Map<TreeNode, Integer> brothers = new HashMap<>();

        while (!queue.isEmpty()) {
            int sum = 0;
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();

                sum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            stageSums.add(sum);
        }

       helper(root, stageSums, brothers, 0);

        return root;
    }

    public void helper(TreeNode root, List<Integer> stageSums, Map<TreeNode, Integer> brothers, int stage) {
        if (root.left != null && root.right != null) {
            brothers.put(root.left, root.right.val);
            brothers.put(root.right, root.left.val);
        }

        root.val = stageSums.get(stage) - root.val;

        if (brothers.containsKey(root)) {
            root.val -= brothers.get(root);
        }

        if (root.left != null) {
            helper(root.left, stageSums, brothers, stage + 1);
        }

        if (root.right != null) {
            helper(root.right, stageSums, brothers, stage + 1);
        }
    }
}
