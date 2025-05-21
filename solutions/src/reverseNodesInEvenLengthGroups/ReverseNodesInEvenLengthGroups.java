package reverseNodesInEvenLengthGroups;

import structures.listNode.ListNode;

public class ReverseNodesInEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int groups = 1;
        int c = 0;
        ListNode dummyHead = new ListNode(0, head);
        ListNode dummy = head;
        ListNode start = head;
        ListNode startPrev = dummyHead;
        ListNode prev;
        while (dummy != null) {
            c++;
            if (c == groups || dummy.next == null) {
                if (c % 2 == 0) {
                    ListNode nextGroupStart = dummy.next;
                    dummy.next = null;
                    ListNode newHead = reverseList(start);
                    startPrev.next = newHead;
                    start.next = nextGroupStart;
                    prev = start;
                    dummy = nextGroupStart;
                } else {
                    prev = dummy;
                    dummy = dummy.next;
                }
                startPrev = prev;
                start = dummy;
                c = 0;
                groups++;
            } else {
                dummy = dummy.next;
            }
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode newNode = null;

        ListNode dummy = head;

        while (dummy != null) {
            ListNode node = dummy;
            dummy = dummy.next;

            node.next = newNode;
            newNode = node;
        }

        return newNode;
    }
}
