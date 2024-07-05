package constructBinaryTreeFromInorderAndPostorderTraversal;

import structures.treeNode.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }

        TreeNode newTreeNode = new TreeNode();

        newTreeNode.val = postorder[postorder.length - 1];

        int postOrderNumberIndexInInorder = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                postOrderNumberIndexInInorder = i;

                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder,0, postOrderNumberIndexInInorder);
        int[] rightInorder = Arrays.copyOfRange(inorder, postOrderNumberIndexInInorder + 1, inorder.length);

        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, postOrderNumberIndexInInorder);
        int[] rightPostorder = Arrays.copyOfRange(postorder, postOrderNumberIndexInInorder, postorder.length - 1);

        if (rightInorder.length != 0) {
            newTreeNode.right = buildTree(rightInorder, rightPostorder);
        }

        if (leftInorder.length != 0) {
            newTreeNode.left = buildTree(leftInorder, leftPostorder);
        }

        return newTreeNode;
    }
}
