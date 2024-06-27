package reverseNodesINKGroup;

import structures.listNode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseNodesINKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        Deque<Integer> stack = new ArrayDeque<>();

        ListNode newListNode = new ListNode();
        ListNode dummy2 = newListNode;
        ListNode prev = null;

        while (head != null) {
            stack.addLast(head.val);

            head = head.next;

            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    int value = stack.pollLast();

                    dummy2.val = value;

                    dummy2.next = new ListNode();
                    prev = dummy2;
                    dummy2 = dummy2.next;
                }
            }
        }

        if (stack.isEmpty()) {
            if (prev != null) {
                prev.next = null;
            }
        } else {
            while (!stack.isEmpty()) {
                int value = stack.pollFirst();

                dummy2.val = value;

                if (!stack.isEmpty()) {
                    dummy2.next = new ListNode();
                    dummy2 = dummy2.next;
                }
            }
        }

        return newListNode;
    }
}
