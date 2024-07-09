package populatingNextRightPointersInEachNode2;

import structures.node.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode2 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            Node prevNode = null;

            for (int i = 0; i < queueSize; i++) {
                Node node = queue.peek();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (prevNode != null) {
                    prevNode.next = node;
                }

                prevNode = node;

                queue.poll();
            }
        }

        return root;
    }
}
