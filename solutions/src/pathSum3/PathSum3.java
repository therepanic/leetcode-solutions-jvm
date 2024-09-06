package pathSum3;

import structures.treeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
    public int pathSum(TreeNode root, int targetSum) {
        int[] pathSum = new int[1];

        bypass(root, new HashMap<>(Map.of(0L, 1)), 0, targetSum, pathSum);

        return pathSum[0];
    }

    public void bypass(TreeNode root, Map<Long, Integer> valueCountMap, long currentSum, int targetSum, int[] pathSum) {
        if (root == null) return;
        currentSum += root.val;

        if (valueCountMap.containsKey(currentSum - targetSum)) {
            pathSum[0] += valueCountMap.get(currentSum - targetSum);
        }

        if (valueCountMap.containsKey(currentSum)) {
            valueCountMap.put(currentSum, valueCountMap.get(currentSum) + 1);
        } else {
            valueCountMap.put(currentSum, 1);
        }

        bypass(root.left, valueCountMap, currentSum, targetSum, pathSum);
        bypass(root.right, valueCountMap, currentSum, targetSum, pathSum);

        if (valueCountMap.get(currentSum) > 1) {
            valueCountMap.put(currentSum, valueCountMap.get(currentSum) - 1);
        } else {
            valueCountMap.remove(currentSum);
        }
    }
}
