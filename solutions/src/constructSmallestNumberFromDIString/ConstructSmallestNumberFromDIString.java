package constructSmallestNumberFromDIString;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructSmallestNumberFromDIString {
    public static String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= pattern.length(); i++) {
            stack.addLast(i + 1);
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pollLast());
                }
            }
        }
        return sb.toString();
    }
}
