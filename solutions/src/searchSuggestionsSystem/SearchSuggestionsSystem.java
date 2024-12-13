package searchSuggestionsSystem;


import java.util.*;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();

        for (String product : products) {
            trie.insert(product);
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String toFound = searchWord.substring(0, i);

            Trie.Node toFoundNode = trie.findNode(toFound);
            List<String> words = new ArrayList<>();

            if (toFoundNode != null) bypass(toFoundNode, toFound, words);

            words.sort(String::compareTo);
            result.add(words.subList(0, Math.min(3, words.size())));
        }

        return result;
    }

    public void bypass(Trie.Node node, String currentWord, List<String> words) {
        if (node.isEndOfWord) {
            words.add(currentWord);
        }

        for (Map.Entry<Character, Trie.Node> entry : node.children.entrySet()) {
            bypass(entry.getValue(), currentWord + entry.getKey(), words);
        }
    }

    static class Trie {

        private static class Node {
            Map<Character, Node> children = new HashMap<>();
            boolean isEndOfWord = false;
        }

        private final Node root = new Node();

        public void insert(String word) {
            Node current = root;
            for (char c : word.toCharArray()) {
                current = current.children.computeIfAbsent(c, k -> new Node());
            }
            current.isEndOfWord = true;
        }

        private Node findNode(String prefix) {
            Node current = root;
            for (char c : prefix.toCharArray()) {
                current = current.children.get(c);
                if (current == null) {
                    return null;
                }
            }
            return current;
        }
    }
}
