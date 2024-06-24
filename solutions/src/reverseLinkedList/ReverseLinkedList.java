package reverseLinkedList;

import structures.listNode.ListNode;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode reversedListNode = null;

        ListNode dummy = head;

        while (dummy != null) {
            ListNode listNode = dummy.next;

            dummy.next = reversedListNode;

            reversedListNode = dummy;

            dummy = listNode;
        }

        return reversedListNode;
    }
}
