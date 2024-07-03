package evenOddTree;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.val % 2 == 0) {
            return false;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        int stage = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int prevNum = -1;

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.peek();

                if (stage % 2 == 0 && node.val % 2 == 0 || stage % 2 != 0 && node.val % 2 != 0) {
                    return false;
                }

                if (prevNum != -1 & stage != 0) {
                    if (stage % 2 == 0 && node.val <= prevNum ||  stage % 2 != 0 && node.val >= prevNum) {
                        return false;
                    }
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                prevNum = node.val;
                queue.poll();
            }

            stage++;
        }

        return true;
    }
}
