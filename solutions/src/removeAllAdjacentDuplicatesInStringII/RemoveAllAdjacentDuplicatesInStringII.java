package removeAllAdjacentDuplicatesInStringII;

import java.util.*;

public class RemoveAllAdjacentDuplicatesInStringII {
    public static String removeDuplicates(String s, int k) {
        char[] sChars = s.toCharArray();
        Deque<Map.Entry<Character, Integer>> stack = new ArrayDeque<>();
        for (int i = 0; i < sChars.length; i++) {
            if (stack.isEmpty() || !stack.getLast().getKey().equals(sChars[i])) {
                stack.addLast(new AbstractMap.SimpleEntry<>(sChars[i], 1));
            } else {
                Map.Entry<Character, Integer> last = stack.pollLast();
                if (last.getValue() + 1 != k) {
                    stack.addLast(new AbstractMap.SimpleEntry<>(last.getKey(), last.getValue() + 1));
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (var entry : stack) {
            answer.repeat(entry.getKey(), entry.getValue());
        }
        return answer.toString();
    }
}
