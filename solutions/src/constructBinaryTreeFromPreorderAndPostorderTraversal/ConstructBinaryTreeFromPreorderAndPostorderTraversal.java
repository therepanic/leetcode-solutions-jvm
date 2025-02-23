package constructBinaryTreeFromPreorderAndPostorderTraversal;

import structures.treeNode.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int[] index = new int[1];
        return bypass(preorder, postorder, index, 0, postorder.length - 1);
    }

    private TreeNode bypass(int[] preorder, int[] postorder, int[] index, int l, int r) {
        if (index[0] >= preorder.length || l > r) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index[0]++]);
        if (l == r) return root;

        int i;
        for (i = l; i <= r; i++) {
            if (postorder[i] == preorder[index[0]]) break;
        }
        root.left = bypass(preorder, postorder, index, l, i);
        root.right = bypass(preorder, postorder, index, i + 1, r - 1);
        return root;
    }
}
