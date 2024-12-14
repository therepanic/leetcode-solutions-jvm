package minimumAbsoluteDifferenceInBST;

import structures.treeNode.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        int[] min = new int[] {Integer.MAX_VALUE};

        bypass(null, null, root, min);

        return min[0];
    }

    public void bypass(Integer low, Integer high, TreeNode root, int[] min) {
         if (root == null) return;

         int diff1 = Integer.MAX_VALUE;
         int diff2 = Integer.MAX_VALUE;

         if (low != null) {
             diff1 = root.val - low;
         }

         if (high != null) {
             diff2 = high - root.val;
         }

         bypass(low, root.val, root.left, min);
         bypass(root.val, high, root.right, min);

         min[0] = Math.min(Math.min(diff2, diff1), min[0]);
    }
}
