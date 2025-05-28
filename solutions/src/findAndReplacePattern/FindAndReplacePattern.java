package findAndReplacePattern;

import java.util.*;

public class FindAndReplacePattern {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            if (check(word, pattern)) {
                answer.add(word);
            }
        }
        return answer;
    }

    public static boolean check(String first, String second) {
        Map<Character, Character> firstMap = new HashMap<>();
        Map<Character, Character> secondMap = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            char f = first.charAt(i);
            char s = second.charAt(i);
            if (firstMap.containsKey(f) && firstMap.get(f) != s) {
                return false;
            }
            if (secondMap.containsKey(s) && secondMap.get(s) != f) {
                return false;
            }
            firstMap.put(f, s);
            secondMap.put(s, f);
        }
        return true;
    }

}
