package cloneGraph;

import java.util.*;

public class CloneGraph {
    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Node clonedNode = new Node();

        helper(clonedNode, node, new HashMap<>());

        return clonedNode;
    }

    public void helper(Node clonedNode, Node realNode, Map<Integer, Node> valueNodeMap) {
         clonedNode.val = realNode.val;

         valueNodeMap.put(clonedNode.val, clonedNode);

         for (Node node : realNode.neighbors) {
             if (valueNodeMap.containsKey(node.val)) {
                 clonedNode.neighbors.add(valueNodeMap.get(node.val));
             } else {
                 Node newNode = new Node();
                 clonedNode.neighbors.add(newNode);

                 helper(newNode, node, valueNodeMap);
             }
         }
    }

}
