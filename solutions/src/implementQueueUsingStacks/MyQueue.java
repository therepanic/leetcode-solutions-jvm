package implementQueueUsingStacks;

import java.util.Stack;

public class MyQueue {

    private final Stack<Integer> first;

    private final Stack<Integer> second;

    public MyQueue() {
        this.first = new Stack<>();
        this.second = new Stack<>();
    }

    public void push(int x) {
        this.first.push(x);
    }

    public int pop() {
        if (this.second.isEmpty()) {
            while (!this.first.isEmpty()) {
                this.second.push(this.first.pop());
            }
        }
        return this.second.pop();
    }

    public int peek() {
        if (this.second.isEmpty()) {
            while (!this.first.isEmpty()) {
                this.second.push(this.first.pop());
            }
        }
        return this.second.peek();
    }

    public boolean empty() {
        return this.first.isEmpty() && this.second.isEmpty();
    }
}
