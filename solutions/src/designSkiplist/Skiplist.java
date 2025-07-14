package designSkiplist;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Skiplist {

    static class Node {
        int val;
        Node next, down;
        public Node(int val, Node next, Node down) {
            this.val = val;
            this.next = next;
            this.down = down;
        }
    }
    private Node head;
    private final Random random;

    public Skiplist() {
        this.head = new Node(-1, null, null);
        this.random = new Random();
    }

    public boolean search(int target) {
        Node dummy = head;
        while (dummy != null) {
            while (dummy.next != null && dummy.next.val < target) {
                dummy = dummy.next;
            }
            if (dummy.next != null && dummy.next.val == target) return true;
            dummy = dummy.down;
        }
        return false;
    }

    public void add(int num) {
        Node dummy = head;
        Deque<Node> stack = new ArrayDeque<>();
        while (dummy != null) {
            while (dummy.next != null && dummy.next.val < num) {
                dummy = dummy.next;
            }
            stack.addLast(dummy);
            dummy = dummy.down;
        }
        boolean insert = true;
        Node down = null;
        while (insert && !stack.isEmpty()) {
            dummy = stack.pollLast();
            dummy.next = new Node(num, dummy.next, down);
            down = dummy.next;
            insert = random.nextDouble() > 0.5;
        }
        if (insert) this.head = new Node(-1, null, head);
    }

    public boolean erase(int num) {
        Node cur = head;
        boolean found = false;
        while (cur != null) {
            while (cur.next != null && cur.next.val < num) {
                cur = cur.next;
            }
            if (cur.next != null && cur.next.val == num) {
                found = true;
                cur.next = cur.next.next;
            }
            cur = cur.down;
        }
        return found;
    }

}
