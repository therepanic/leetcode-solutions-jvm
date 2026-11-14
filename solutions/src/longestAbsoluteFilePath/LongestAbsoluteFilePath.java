package longestAbsoluteFilePath;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : input.split("\n")) {
            int lev = s.lastIndexOf('\t') + 1;
            while (stack.size() > lev) {
                stack.pop();
            }
            int parentLen = stack.isEmpty() ? 0 : stack.peek() + 1;
            int len = parentLen + s.length() - lev;
            stack.push(len);
            if (s.contains(".")) {
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
