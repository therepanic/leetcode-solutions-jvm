package insufficientNodesInRootToLeafPaths;

import structures.treeNode.TreeNode;

public class InsufficientNodesInRootToLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return helper(root, limit, 0).firstValue;
    }

    public Pair<TreeNode, Integer> helper(TreeNode root, int limit, int pathSum) {
        pathSum += root.val;

        if (root.left == null && root.right == null) {
            if (pathSum < limit) {
                return new Pair<>(null, pathSum);
            }

            return new Pair<>(root, pathSum);
        }

        int maxLeftPathSum = Integer.MIN_VALUE;
        int maxRightPathSum = Integer.MIN_VALUE;

        if (root.left != null) {
            var maxLeftPathPair = helper(root.left, limit, pathSum);

            root.left = maxLeftPathPair.firstValue;
            maxLeftPathSum = maxLeftPathPair.secondValue;
        }

        if (root.right != null) {
            var maxRightPathPair = helper(root.right, limit, pathSum);

            root.right = maxRightPathPair.firstValue;
            maxRightPathSum = maxRightPathPair.secondValue;
        }

        if (maxLeftPathSum < limit && maxRightPathSum < limit) {
            return new Pair<>(null, Math.max(maxLeftPathSum, maxRightPathSum));
        }

        return new Pair<>(root, Math.max(maxLeftPathSum, maxRightPathSum));
    }

    public static class Pair<T, J> {
        public Pair(T firstValue, J secondValue) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }

        public T firstValue;
        public J secondValue;
    }
}
