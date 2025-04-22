package reverseSubstringsBetweenEachPairOfParentheses;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        char[] sChars = s.toCharArray();
        StringBuilder cur = new StringBuilder();
        for (char c : sChars) {
            if (c != '(' && c != ')') {
                cur.append(c);
            } else if (c == '(') {
                stack.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.reverse();
                if (!stack.isEmpty()) {
                    cur.insert(0, stack.pop());
                }
            }
        }
        return cur.toString();
    }
}
