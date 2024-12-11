package removingStarsFromAString;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemovingStarsFromAString {
        public String removeStars(String s) {
            Deque<Character> stack = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                if (c != '*') {
                    stack.addLast(c);
                } else {
                    stack.removeLast();
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!stack.isEmpty()) {
                sb.append(stack.pollFirst());
            }

            return sb.toString();
        }
}
