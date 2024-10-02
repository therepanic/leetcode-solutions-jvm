package minStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.addLast(val);

        if (minStack.isEmpty()) {
            minStack.addLast(val);
        } else {

            minStack.addLast(Math.min(val, minStack.getLast()));
        }
    }

    public void pop() {
        if (!stack.isEmpty() && !minStack.isEmpty()) {
            stack.removeLast();
            minStack.removeLast();
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minStack.getLast();
    }
}
