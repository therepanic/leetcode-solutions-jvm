package minimumNumberOfOperationsToSortABinaryTreeByLevel;

import structures.treeNode.TreeNode;

import java.util.*;

public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        int count = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            List<Integer> values = new ArrayList<>();

            for (int i = 0; i < queueSize; i++) {
                TreeNode poll = queue.poll();

                values.add(poll.val);

                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }

            List<int[]> sortedValues = new ArrayList<>();

            for (int i = 0; i < values.size(); i++) {
                sortedValues.add(new int[] {values.get(i), i});
            }

            sortedValues.sort(Comparator.comparingInt(p -> p[0]));

            count += checkSwaps(sortedValues);
        }

        return count;
    }

    public int checkSwaps(List<int[]> sortedValues) {
        boolean[] visited = new boolean[sortedValues.size()];

        int swapCount = 0;

        for (int i = 0; i < sortedValues.size(); i++) {
            if (visited[i] || sortedValues.get(i)[1] == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = sortedValues.get(j)[1];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swapCount += cycleSize - 1;
            }
        }

        return swapCount;
    }
}
