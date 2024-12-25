package designAddAndSearchWordsDataStructure;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    private final Node root;
    public WordDictionary() {
        root = new Node(new HashMap<>());
    }

    public void addWord(String word) {
        Node cur = root;

        for (char c : word.toCharArray()) {
            cur.charMap.putIfAbsent(c, new Node(new HashMap<>()));
            cur = cur.charMap.get(c);
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return searchInternal(word, 0, root);
    }

    public boolean searchInternal(String word, int index, Node node) {
        if (index == word.length()) {
            return node.end;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (Node child : node.charMap.values()) {
                if (searchInternal(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            Node buff = node.charMap.get(c);

            return buff != null  &&  searchInternal(word, index + 1, buff);
        }
    }

    public static class Node {
        public boolean end;

        public Node (Map<Character, Node> charMap) {
            this.charMap = charMap;
        }

        public Map<Character, Node> charMap;
    }
}
