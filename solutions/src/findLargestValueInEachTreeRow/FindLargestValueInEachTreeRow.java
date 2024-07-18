package findLargestValueInEachTreeRow;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> largestValues = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int largestValue = Integer.MIN_VALUE;

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.peek();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                largestValue = Math.max(largestValue, node.val);

                queue.poll();
            }

            largestValues.add(largestValue);
        }

        return largestValues;
    }
}
