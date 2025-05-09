package usingARobotToPrintTheLexicographicallySmallestString;

import java.util.ArrayDeque;
import java.util.Deque;

public class UsingARobotToPrintTheLexicographicallySmallestString {
    public static String robotWithString(String s) {
        char[] sChars = s.toCharArray();
        char[] minChars = new char[s.length()];
        Character minCh = null;
        for (int i = sChars.length - 1; i >= 0; i--) {
            if (minCh == null) {
                minCh = sChars[i];
            } else if (minCh.compareTo(sChars[i]) > 0) {
                minCh = sChars[i];
            }
            minChars[i] = minCh;
        }
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < sChars.length; i++) {
            while (!stack.isEmpty() && minChars[i] >= stack.getLast()) {
                sb.append(stack.pollLast());
            }
            stack.addLast(sChars[i]);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
