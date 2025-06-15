package resultingStringAfterAdjacentRemovals;

import java.util.ArrayDeque;
import java.util.Deque;

public class ResultingStringAfterAdjacentRemovals {

    public static String resultingString(String s) {
        char[] sChars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        first: for (char c : sChars) {
            if (stack.isEmpty()) {
                stack.addLast(c);
            } else {
                while (!stack.isEmpty() && extract(stack, c)) {
                    stack.pollLast();
                    if (stack.size() > 1) {
                        c = stack.pollLast();
                    } else {
                       continue first;
                    }
                }
                if (stack.size() <= 1 || !extract(stack, c)) {
                    stack.addLast(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static boolean extract(Deque<Character> stack, char ch) {
        if (!stack.isEmpty()) {
            char stackCh = stack.getLast();
            if (stackCh == 'z' && ch == 'a' || ch == 'z' && stackCh == 'a') {
                return true;
            }
            int valFirst = ch - 'a';
            int valSecond = stackCh - 'a';
            return Math.abs(valSecond - valFirst) == 1;
        }
        return false;
    }

}
