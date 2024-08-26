package naryTreePostorderTraversal;

import structures.node.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> postorder = new ArrayList<>();

        helper(root, postorder);

        postorder.add(root.val);

        return postorder;
    }

    public void helper(Node root, List<Integer> postorder) {
        for (Node node : root.children) {
            helper(node, postorder);
            postorder.add(node.val);
        }
    }

}
