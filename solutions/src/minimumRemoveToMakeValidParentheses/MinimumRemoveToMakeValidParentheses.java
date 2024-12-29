package minimumRemoveToMakeValidParentheses;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static String minRemoveToMakeValid(String s) {
        char[] sChars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int deletedIndex = 0;

        for (int i = 0; i < sChars.length; i++) {
            char c = sChars[i];

            if (c == '(') {
                stack.add(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                } else {
                    deletedIndex++;
                    continue;
                }
            }
            sb.append(c);
        }

        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop() - deletedIndex);
        }
        return sb.toString();
    }
}
