package implementTrie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private final Node node = new Node();
    public Trie() {
    }

    public void insert(String word) {
        Node currentNode = node;

        for (char c : word.toCharArray()) {
            if (currentNode.prefixNodeMap.containsKey(c)) {
                currentNode  = currentNode.prefixNodeMap.get(c);
                continue;
            }

            Node newNode = new Node();

            currentNode.prefixNodeMap.put(c, newNode);
            currentNode = newNode;
        }

        currentNode.prefixNodeMap.put(word, null);
    }

    public boolean search(String word) {
        Node currentNode = node;

        for (char c : word.toCharArray()) {
            currentNode = currentNode.prefixNodeMap.get(c);

            if (currentNode == null) {
                return false;
            }
        }

        return currentNode.prefixNodeMap.containsKey(word);
    }

    public boolean startsWith(String prefix) {
        Node currentNode = node;

        for (char c : prefix.toCharArray()) {
            currentNode = currentNode.prefixNodeMap.get(c);

            if (currentNode == null) {
                return false;
            }
        }

        return true;
    }

    public static class Node {
        public final Map<Object, Node> prefixNodeMap = new HashMap<>();
    }
}
