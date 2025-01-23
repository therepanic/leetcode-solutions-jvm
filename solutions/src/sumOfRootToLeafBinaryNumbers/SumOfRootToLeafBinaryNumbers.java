package sumOfRootToLeafBinaryNumbers;

import structures.treeNode.TreeNode;

public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        return bypass(root, new StringBuilder());
    }

    public int bypass(TreeNode root, StringBuilder sb) {
        if (root == null) return 0;
        sb.append(root.val);
        int fir = bypass(root.left, sb);
        int sec = bypass(root.right, sb);
        if (root.left == null && root.right == null) {
            String s = sb.toString();
            sb.deleteCharAt(sb.length() - 1);
            return Integer.parseInt(s, 2);
        }
        sb.deleteCharAt(sb.length() - 1);
        return fir + sec;
    }
}
