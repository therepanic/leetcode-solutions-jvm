package validateStackSequences;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < pushed.length && j < popped.length; i++) {
            stack.addLast(pushed[i]);
            while (!stack.isEmpty() && j < popped.length && stack.getLast().equals(popped[j])) {
                stack.pollLast();
                j++;
            }
        }
        while (!stack.isEmpty() && j < popped.length && stack.getLast().equals(popped[j])) {
            stack.pollLast();
            j++;
        }
        return stack.isEmpty();
    }
}
