package constructBinaryTreeFromPreorderAndInorderTraversal;

import structures.treeNode.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode newTreeNode = new TreeNode();

        newTreeNode.val = preorder[0];

        int preorderValueIndexInInOrder = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                preorderValueIndexInInOrder = i;
                break;
            }
        }

        preorder = Arrays.stream(preorder, 1, preorder.length).toArray();

        int[] preorderLeft = Arrays.copyOfRange(preorder, 0, preorderValueIndexInInOrder);
        int[] preorderRight = Arrays.copyOfRange(preorder, preorderValueIndexInInOrder, preorder.length);

        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, preorderValueIndexInInOrder);
        int[] inorderRight = Arrays.copyOfRange(inorder, preorderValueIndexInInOrder + 1, inorder.length);

        if (inorderLeft.length != 0) {
            newTreeNode.left = buildTree(preorderLeft, inorderLeft);
        }

        if (inorderRight.length != 0) {
            newTreeNode.right = buildTree(preorderRight, inorderRight);
        }

        return newTreeNode;
    }
}
