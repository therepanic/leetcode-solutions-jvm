package minimumDistanceBetweenBSTNodes;

import structures.treeNode.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        int[] min = new int[] {Integer.MAX_VALUE};
        dfs(null, root, null, min);
        return min[0];
    }

    public void dfs(Integer low, TreeNode node, Integer high, int[] min){
        if(node == null){
            return;
        }

        int diff1 = Integer.MAX_VALUE;

        if (low != null){
            diff1 = node.val - low;
        }

        int diff2 = Integer.MAX_VALUE;

        if (high != null){
            diff2 = high - node.val;
        }

        min[0] = Math.min(Math.min(diff1, diff2), min[0]);

        dfs(low, node.left, node.val, min);
        dfs(node.val, node.right, high, min);
    }
}
