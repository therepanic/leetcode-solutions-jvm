package implementStackUsingQueues;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {

    private final Queue<Integer> queue = new ArrayDeque<>();
    public MyStack() {
    }

    public void push(int x) {
        this.queue.add(x);
    }

    public int pop() {
        int size = this.queue.size();
        for (int i = 0; i < size - 1; i++) {
            this.queue.add(this.queue.poll());
        }
        int val = this.queue.poll();
        return val;
    }

    public int top() {
        int val = pop();
        this.queue.add(val);
        return val;
    }

    public boolean empty() {
        return this.queue.isEmpty();
    }

}
