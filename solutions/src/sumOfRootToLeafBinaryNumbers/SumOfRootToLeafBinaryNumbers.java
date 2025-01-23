package sumOfRootToLeafBinaryNumbers;

import structures.treeNode.TreeNode;

public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        int[] num = new int[1];
        bypass(root, num, new StringBuilder());
        return num[0];
    }

    public void bypass(TreeNode root, int[] num, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        bypass(root.left, num, sb);
        bypass(root.right, num, sb);
        if (root.left == null && root.right == null) {
            num[0]+=Integer.parseInt(sb.toString(), 2);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}
