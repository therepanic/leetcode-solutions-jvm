package removeNthNodeFromEndOfList;

import structures.listNode.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        int headSize = 0;

        while (dummy != null) {
            headSize++;
            dummy = dummy.next;
        }

        dummy = head;

        int nFromBegin = headSize - n + 1;

        int currentIndex = 1;

        ListNode newListNode = null;
        ListNode newListNodeDummy = null;

        ListNode prev = null;
        while (dummy != null) {
            if (currentIndex == nFromBegin) {
                currentIndex++;

                dummy = dummy.next;
                continue;
            }

            if (newListNode == null) {
                newListNode = new ListNode();
                newListNodeDummy = newListNode;
            }

            newListNodeDummy.val = dummy.val;

            prev = newListNodeDummy;
            newListNodeDummy.next = new ListNode();
            newListNodeDummy = newListNodeDummy.next;

            currentIndex++;
            dummy = dummy.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return newListNode;
    }
}
