package recoverATreeFromPreorderTraversal;

import structures.treeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecoverATreeFromPreorderTraversal {
    public TreeNode recoverFromPreorder(String traversal) {
        Pattern pattern = Pattern.compile("(-*)(\\d+)");
        Matcher matcher = pattern.matcher(traversal);
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (matcher.find()) {
            int depth = matcher.group(1).length();
            int nodeVal = Integer.parseInt(matcher.group(2));
            TreeNode node = new TreeNode(nodeVal);
            while (stack.size() > depth) {
                stack.pollLast();
            }
            if (!stack.isEmpty()) {
                TreeNode parent = stack.getLast();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            stack.addLast(node);
        }
        while (stack.size() > 1) {
            stack.pollLast();
        }
        return stack.isEmpty() ? null : stack.pollLast();
    }
}
