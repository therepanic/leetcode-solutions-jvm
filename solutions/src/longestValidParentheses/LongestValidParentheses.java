package longestValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] sChars = s.toCharArray();
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>(List.of(-1));
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addLast(i);
            } else {
                stack.pollLast();
                if (stack.isEmpty()) {
                    stack.addLast(i);
                } else {
                    answer = Math.max(answer, i - stack.getLast());
                }

            }
        }
        return answer + 1;
    }
}
