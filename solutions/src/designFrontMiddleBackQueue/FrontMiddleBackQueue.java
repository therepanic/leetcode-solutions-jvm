package designFrontMiddleBackQueue;

import java.util.LinkedList;

public class FrontMiddleBackQueue {
    private final LinkedList<Integer> linkedList;
    public FrontMiddleBackQueue() {
        this.linkedList = new LinkedList<>();

    }

    public void pushFront(int val) {
        linkedList.addFirst(val);
    }

    public void pushMiddle(int val) {
        linkedList.add(linkedList.size() / 2, val);
    }

    public void pushBack(int val) {
        linkedList.addLast(val);
    }

    public int popFront() {
        if (linkedList.isEmpty()) return -1;

        return linkedList.pollFirst();
    }

    public int popMiddle() {
        if (linkedList.isEmpty()) return -1;

        return linkedList.remove((linkedList.size() - 1) / 2);
    }

    public int popBack() {
        if (linkedList.isEmpty()) return -1;

        return linkedList.pollLast();
    }
}
