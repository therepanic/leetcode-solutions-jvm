package countCollisionsOnARoad;

import java.util.Stack;

public class CountCollisionsOnARoad {
    public static int countCollisions(String directions) {
        char[] dirs = directions.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < dirs.length; i++) {
            char c = dirs[i];
            if (c == 'S') {
                while (!stack.isEmpty() && stack.getLast() == 'R') {
                    stack.pop();
                    count++;
                }
                stack.add(c);
            } else if (c == 'L') {
                if (!stack.isEmpty() && stack.getLast() == 'R') {
                    count += 2;
                    stack.pop();
                    while (!stack.isEmpty() && stack.getLast() == 'R') {
                        count++;
                        stack.pop();
                    }
                    stack.push('S');
                } else if (!stack.isEmpty() && stack.getLast() == 'S') {
                    count++;
                }
            } else if (c == 'R') {
                stack.add(c);
            }
        }
        return count;
    }
}
