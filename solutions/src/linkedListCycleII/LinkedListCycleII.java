package linkedListCycleII;

import structures.listNode.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode faster = head;
        ListNode slower = head;

        do {
            if (slower.next == null) {
                return null;
            }

            slower = slower.next;

            if (faster.next == null || faster.next.next == null) {
                return null;
            }

            faster = faster.next.next;

        } while (faster != slower);

        faster = head;

        while (faster != slower) {
            slower = slower.next;
            faster = faster.next;
        }

        return faster;
    }
}
