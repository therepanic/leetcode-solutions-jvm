package binaryTreeColoringGame;

import structures.treeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeColoringGame {

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        bypass(root, nodeMap);
        int blueCount = count(root, x);
        if (blueCount > n / 2) return true;
        if (nodeMap.get(x).left != null) {
            int c = count(nodeMap.get(x).left, x);
            if (c > n / 2) return true;
        }
        if (nodeMap.get(x).right != null) {
            int c = count(nodeMap.get(x).right, x);
            if (c > n / 2) return true;
        }
        return false;
    }

    public void bypass(TreeNode root, Map<Integer, TreeNode> nodeMap) {
        if (root == null) return;
        nodeMap.put(root.val, root);
        bypass(root.left, nodeMap);
        bypass(root.right, nodeMap);
    }

    public int count(TreeNode root, int x) {
        if (root == null || root.val == x) return 0;
        return count(root.left, x) + count(root.right, x) + 1;
    }

}
