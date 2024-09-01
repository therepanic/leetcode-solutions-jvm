package completeBinaryTreeInserter;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class CBTInserter {
    private final TreeNode root;
    private final Queue<TreeNode> leafNodes;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.leafNodes = new ArrayDeque<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left == null || node.right == null) {
                this.leafNodes.add(node);
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public int insert(int val) {
        TreeNode node = this.leafNodes.peek();

        if (node.left == null) {
            node.left = new TreeNode(val);
            this.leafNodes.add(node.left);
        } else if (node.right == null) {
            node.right = new TreeNode(val);
            this.leafNodes.add(node.right);
        }

        if (node.left != null && node.right != null) {
            this.leafNodes.poll();
        }

        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
