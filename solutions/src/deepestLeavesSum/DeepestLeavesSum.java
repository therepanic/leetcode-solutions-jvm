package deepestLeavesSum;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int maxStageLeavesSum = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int currentStageSum = 0;
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                currentStageSum += queue.peek().val;

                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }

                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }

                queue.poll();
            }

            maxStageLeavesSum = currentStageSum;
        }

        return maxStageLeavesSum;
    }
}
