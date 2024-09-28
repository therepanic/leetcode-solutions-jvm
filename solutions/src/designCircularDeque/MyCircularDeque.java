package designCircularDeque;

import java.util.LinkedList;

public class MyCircularDeque {
    private final int size;
    private final LinkedList<Integer> core = new LinkedList<>();

    public MyCircularDeque(int k) {
        this.size = k;
    }

    public boolean insertFront(int value) {
        if (core.size() == size) return false;

        core.addFirst(value);
        return true;
    }

    public boolean insertLast(int value) {
        if (core.size() == size) return false;

        core.addLast(value);
        return true;
    }

    public boolean deleteFront() {
        if (core.isEmpty()) return false;
        core.removeFirst();
        return true;
    }

    public boolean deleteLast() {
        if (core.isEmpty()) return false;
        core.removeLast();
        return true;
    }

    public int getFront() {
        if (core.isEmpty()) return -1;
        return core.getFirst();
    }

    public int getRear() {
        if (core.isEmpty()) return -1;
        return core.getLast();
    }

    public boolean isEmpty() {
        return core.isEmpty();
    }

    public boolean isFull() {
        return core.size() == size;
    }
}
