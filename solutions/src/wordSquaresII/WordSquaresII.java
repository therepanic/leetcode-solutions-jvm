package wordSquaresII;

import java.util.*;

public class WordSquaresII {
    public List<List<String>> wordSquares(String[] words) {
        Arrays.sort(words);
        List<List<String>> answer = new ArrayList<>();
        List<Integer>[] byFirst = new ArrayList[26];
        List<Integer>[][] byFirstLast = new ArrayList[26][26];
        for (int i = 0; i < 26; i++) {
            byFirst[i] = new ArrayList<>();
            for (int j = 0; j < 26; j++) {
                byFirstLast[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < words.length; i++) {
            int f = words[i].charAt(0) - 'a';
            int l = words[i].charAt(3) - 'a';
            byFirst[f].add(i);
            byFirstLast[f][l].add(i);
        }
        check(words, answer, new ArrayList<>(), new boolean[words.length], byFirst, byFirstLast);
        return answer;
    }

    public void check(String[] words, List<List<String>> answer, List<String> cur,
                      boolean[] used, List<Integer>[] byFirst, List<Integer>[][] byFirstLast) {
        int size = cur.size();
        if (size == 4) {
            answer.add(new ArrayList<>(cur));
            return;
        }
        if (size == 0) {
            for (int i = 0; i < words.length; i++) {
                if (used[i]) continue;
                used[i] = true;
                cur.add(words[i]);
                check(words, answer, cur, used, byFirst, byFirstLast);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
            return;
        }
        if (size == 1) {
            int need = cur.get(0).charAt(0) - 'a';
            for (int i : byFirst[need]) {
                if (used[i]) continue;
                used[i] = true;
                cur.add(words[i]);
                check(words, answer, cur, used, byFirst, byFirstLast);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
            return;
        }
        if (size == 2) {
            int need = cur.get(0).charAt(3) - 'a';
            for (int i : byFirst[need]) {
                if (used[i]) continue;
                used[i] = true;
                cur.add(words[i]);
                check(words, answer, cur, used, byFirst, byFirstLast);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
            return;
        }
        int needFirst = cur.get(1).charAt(3) - 'a';
        int needLast  = cur.get(2).charAt(3) - 'a';
        for (int i : byFirstLast[needFirst][needLast]) {
            if (used[i]) continue;
            used[i] = true;
            cur.add(words[i]);
            check(words, answer, cur, used, byFirst, byFirstLast);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }

}
