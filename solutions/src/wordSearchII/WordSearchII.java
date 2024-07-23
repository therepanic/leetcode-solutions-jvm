package wordSearchII;

import implementTrie.Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public static void main(String[] args) {
        System.out.println(findWords(new char[][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new String[] {"oath","pea","eat","rain"}));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (trie.startsWith(String.valueOf(board[i][j]))) {
                    check(i, j, board, new int[board.length][board[0].length], "", answer, trie);
                }
            }
        }

        return answer;
    }

    private static void check (int n, int m, char[][] board, int[][] checked, String word, List<String> answer, Trie trie) {
        if (n < 0 || m < 0 || n >= board.length || m >= board[n].length || checked[n][m] == 1) {
            return;
        }

        checked[n][m] = 1;
        word += board[n][m];

        if (trie.search(word) && !answer.contains(word)) {
            answer.add(word);
        }

        if (trie.startsWith(word)) {
            check(n - 1, m, board, checked, word, answer, trie);
            check(n + 1, m, board, checked, word, answer, trie);
            check(n, m - 1, board, checked, word, answer, trie);
            check(n, m + 1, board, checked, word, answer, trie);

        }
        checked[n][m] = 0;
    }

}
