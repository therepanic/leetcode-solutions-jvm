package partitionString;

import java.util.ArrayList;
import java.util.List;

public class PartitionString {
    static class FastTrie {
        private static class Node {
            Node[] children = new Node[26];
            boolean isWord;
        }

        private final Node root = new Node();

        public void insert(String word) {
            Node node = root;
            for (int i = 0, len = word.length(); i < len; i++) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Node();
                }
                node = node.children[idx];
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            Node node = findNode(word);
            return node != null && node.isWord;
        }

        public boolean startsWith(String prefix) {
            return findNode(prefix) != null;
        }

        private Node findNode(String s) {
            Node node = root;
            for (int i = 0, len = s.length(); i < len; i++) {
                int idx = s.charAt(i) - 'a';
                if (idx < 0 || idx >= 26 || node.children[idx] == null) return null;
                node = node.children[idx];
            }
            return node;
        }
    }

    public List<String> partitionString(String s) {
        List<String> ans = new ArrayList<>();
        FastTrie fastTrie = new FastTrie();
        StringBuilder curStr = new StringBuilder();
        for (int r = 0; r < s.length(); r++) {
            curStr.append(s.charAt(r));
            String val = curStr.toString();
            if (!fastTrie.search(val)) {
                ans.add(val);
                curStr.setLength(0);
                fastTrie.insert(val);
            }
        }
        return ans;
    }
}
