package constructStringFromBinaryTree;

import structures.treeNode.TreeNode;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        print(root, sb);

        return sb.toString();
    }

    public void print(TreeNode root, StringBuilder sb) {
        sb.append(root.val);

        if (root.left != null) {
            sb.append("(");
            print(root.left, sb);
            sb.append(")");
        }

        if (root.left == null && root.right != null) {
            sb.append("()");
        }

        if (root.right != null) {
            sb.append("(");
            print(root.right, sb);
            sb.append(")");
        }
    }
}
