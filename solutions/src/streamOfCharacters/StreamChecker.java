package streamOfCharacters;

import java.util.ArrayList;
import java.util.List;

public class StreamChecker {
    private final Trie trie;

    private final List<TrieNode> wait;

    public StreamChecker(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        this.trie = trie;
        this.wait = new ArrayList<>();
    }

    public boolean query(char letter) {
        boolean exist = false;
        for (int i = 0; i < this.wait.size(); i++) {
            var node = this.wait.get(i);
            if (node.children[letter - 'a'] != null) {
                TrieNode newNode = node.children[letter - 'a'];
                this.wait.set(i, newNode);
                if (newNode.isEnd) {
                    exist = true;
                }
            } else {
                this.wait.remove(i);
                i--;
            }
        }
        TrieNode a = this.trie.root.children[letter - 'a'];
        if (a != null) {
            this.wait.add(a);
            if (a.isEnd) {
                exist = true;
            }
        }
        return exist;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEnd = true;
        }
    }
}
