package validParentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.addLast(c);
            } else if (c == ']' || c == ')' || c == '}') {
                if (stack.peekLast() != null) {
                    if (c == ']' && stack.peekLast() != '[' || c == ')' && stack.peekLast() != '(' || c == '}' && stack.peekLast() != '{') {
                        return false;
                    }
                } else {
                    return false;
                }

                stack.pollLast();
            }
        }

        return stack.isEmpty();
    }
}
