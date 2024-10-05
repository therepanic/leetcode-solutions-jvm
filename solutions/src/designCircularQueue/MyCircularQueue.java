package designCircularQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyCircularQueue {
    private final Deque<Integer> core;
    private final int k;
    public MyCircularQueue(int k) {
        this.core = new ArrayDeque<>();
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (core.size() == k) return false;

        core.addLast(value);

        return true;
    }

    public boolean deQueue() {
        if (core.isEmpty()) return false;

        core.removeFirst();

        return true;
    }

    public int Front() {
        if (core.isEmpty()) return -1;

        return core.getFirst();
    }

    public int Rear() {
        if (core.isEmpty()) return -1;

        return core.getLast();
    }

    public boolean isEmpty() {
        return core.isEmpty();
    }

    public boolean isFull() {
        return core.size() == k;
    }
}
