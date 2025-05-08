package maximumScoreFromRemovingSubstrings;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumScoreFromRemovingSubstrings {
    public static int maximumGain(String s, int x, int y) {
        char[] sChars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int c = 0;
        if (y > x) {
            for (int i = 0; i < sChars.length; i++) {
                if (!stack.isEmpty()) {
                    if (stack.getLast().equals('b') && sChars[i] == 'a') {
                        c += y;
                        stack.pollLast();
                    } else {
                        stack.addLast(sChars[i]);
                    }
                } else {
                    stack.addLast(sChars[i]);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char ch : stack) {
                sb.append(ch);
            }
            sChars = sb.toString().toCharArray();
            stack.clear();
            for (int i = 0; i < sChars.length; i++) {
                if (!stack.isEmpty()) {
                    if (stack.getLast().equals('a') && sChars[i] == 'b') {
                        c += x;
                        stack.pollLast();
                    } else {
                        stack.addLast(sChars[i]);
                    }
                } else {
                    stack.addLast(sChars[i]);
                }
            }
        } else {
            for (int i = 0; i < sChars.length; i++) {
                if (!stack.isEmpty()) {
                    if (stack.getLast().equals('a') && sChars[i] == 'b') {
                        c += x;
                        stack.pollLast();
                    } else {
                        stack.addLast(sChars[i]);
                    }
                } else {
                    stack.addLast(sChars[i]);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char ch : stack) {
                sb.append(ch);
            }
            sChars = sb.toString().toCharArray();
            stack.clear();
            for (int i = 0; i < sChars.length; i++) {
                if (!stack.isEmpty()) {
                    if (stack.getLast().equals('b') && sChars[i] == 'a') {
                        c += y;
                        stack.pollLast();
                    } else {
                        stack.addLast(sChars[i]);
                    }
                } else {
                    stack.addLast(sChars[i]);
                }
            }
        }
        return c;
    }
}
