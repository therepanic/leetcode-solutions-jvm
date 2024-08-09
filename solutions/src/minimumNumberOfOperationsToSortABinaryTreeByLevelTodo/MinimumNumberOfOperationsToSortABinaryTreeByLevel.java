package minimumNumberOfOperationsToSortABinaryTreeByLevelTodo;

import structures.treeNode.TreeNode;

import java.util.*;

public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {
    //todo
    public int minimumOperations(TreeNode root) {
        int minimumOperations = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            List<Integer> values = new ArrayList<>();

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                values.add(node.val);
            }

            minimumOperations += selectionSort(values);
        }

        return minimumOperations;
    }

    public int selectionSort(List<Integer> nums) {
        int count = 0;

        for (int step = 0; step < nums.size(); step++) {
            int minNum = nums.get(step);
            int minNumIndex = step;

            for (int i = step ; i < nums.size(); i++) {
                if (nums.get(i) < minNum) {
                    minNum = nums.get(i);
                    minNumIndex = i;
                }
            }

            if (nums.get(step) != minNum) {
                int buffer = nums.get(step);

                nums.set(step, minNum);
                nums.set(minNumIndex, buffer);

                count++;
            }
        }

        return count;
    }
}
