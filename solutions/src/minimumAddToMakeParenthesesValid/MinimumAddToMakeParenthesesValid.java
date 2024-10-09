package minimumAddToMakeParenthesesValid;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (c == ')' && stack.getLast() == '(') {
                    stack.removeLast();
                } else {
                    stack.addLast(c);
                }
            } else {
                stack.addLast(c);
            }
        }

        return stack.size();
    }
}
