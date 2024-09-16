package smallestStringStartingFromLeaf;

import structures.treeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SmallestStringStartingFromLeaf {
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) return "";

        List<Integer> currentPath = new LinkedList<>();
        String[] smallestString = new String[1];

        dfs(root, currentPath, smallestString);

        return smallestString[0];
    }

    private void dfs(TreeNode node, List<Integer> currentPath, String[] smallestString) {
        if (node == null) return;

        currentPath.addFirst(node.val);

        if (node.left == null && node.right == null) {
            String candidate = buildStringFromPath(currentPath);
            if (smallestString[0] == null || candidate.compareTo(smallestString[0]) < 0) {
                smallestString[0] = candidate;
            }
        }

        dfs(node.left, currentPath, smallestString);
        dfs(node.right, currentPath, smallestString);

        currentPath.removeFirst();
    }

    private String buildStringFromPath(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int val : path) {
            sb.append(alphabet[val]);
        }
        return sb.toString();
    }
}
